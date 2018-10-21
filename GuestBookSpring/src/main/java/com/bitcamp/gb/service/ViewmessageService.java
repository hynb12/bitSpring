package com.bitcamp.gb.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.gb.dao.MessageDao;
import com.bitcamp.gb.jdbc.ConnectionProvider;
import com.bitcamp.gb.model.Message;

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