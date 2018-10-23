package com.bitcamp.op.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.dao.MessageDao;
import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.model.Message;

public class ViewmessageService {
	
	@Autowired
	private MessageDao messageDao;
	
	private Connection conn;
	
	public Message getMessage(int id) throws SQLException {
		
		conn = ConnectionProvider.getConnection();
		
		Message resultObj = messageDao.select(conn, id); 
		
		return  resultObj;
		
		
	}
	
	
	
	
	
	
	
}