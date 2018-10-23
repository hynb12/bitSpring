package com.bitcamp.op.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.model.Message;

public class MessageDao {

	public int insert(Connection conn, Message message) throws SQLException {

		PreparedStatement pstmt = null;
		// int resultCnt = 0;
		try {
			pstmt = conn.prepareStatement("insert into guestbook_message "
					+ "(message_id, guest_name, password, message) " + "values (?, ?, ?, ?)");
			pstmt.setInt(1, message.getId());
			pstmt.setString(2, message.getGuestName());
			pstmt.setString(3, message.getPassword());
			pstmt.setString(4, message.getMessage());
			// resultCnt = pstmt.executeUpdate();
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}

	}

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from guestbook_message");
			rs.next();
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<Message> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Message> messageList = new ArrayList<Message>();
		String select_sql = "select * from guestbook_message order by message_id desc limit ?, ?";

		try {
			pstmt = conn.prepareStatement(select_sql);

//			오라클
//			pstmt.setInt(1, firstRow);
//			pstmt.setInt(2, endRow);
			// 오라클이랑 반대 mysql은 처음이 먼저
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					messageList.add(makeMessageFromResultSet(rs));
				} while (rs.next());
				// return messageList;
			} else {
				// return Collections.emptyList();
				messageList = Collections.emptyList();
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return messageList;
	}

	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("message_id"));
		message.setGuestName(rs.getString("guest_name"));
		message.setPassword(rs.getString("password"));
		message.setMessage(rs.getString("message"));
		return message;
	}

	public Message select(Connection conn, int messageId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from guestbook_message where message_id = ?");
			pstmt.setInt(1, messageId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return makeMessageFromResultSet(rs);
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public void delete(Connection conn, int messageId) throws SQLException {
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("delete from guestbook_message where message_id = ?");
			pstmt.setInt(1, messageId);
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}

	}

}