package com.bitcamp.op.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.dao.MessageDao;
import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.model.Message;

public class DeleteMessageService {

	@Autowired
	MessageDao messageDao;

	public void deleteMessage(int messageId, String password)
			throws ServiceException, InvalidMessagePassowrdException, MessageNotFoundException {

		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Message message = messageDao.select(conn, messageId);
			if (message == null) {
				throw new MessageNotFoundException("메시지가 없습니다:" + messageId);
			}
			if (!message.hasPassword()) {
				throw new InvalidMessagePassowrdException();
			}
			if (!message.getPassword().equals(password)) {
				throw new InvalidMessagePassowrdException();
			}
			messageDao.delete(conn, messageId);
			conn.commit();
		} catch (SQLException ex) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("삭제 처리 중 에러가 발생했습니다:" + ex.getMessage(), ex);
		} catch (InvalidMessagePassowrdException ex) {
			JdbcUtil.rollback(conn);
			throw ex;
		} catch (MessageNotFoundException ex) {
			JdbcUtil.rollback(conn);
			throw ex;
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(false);
				} catch (SQLException e) {
				}
				JdbcUtil.close(conn);
			}
		}

	}

}