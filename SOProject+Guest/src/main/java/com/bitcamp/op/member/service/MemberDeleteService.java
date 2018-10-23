package com.bitcamp.op.member.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.model.MemberInfo;

public class MemberDeleteService {

	@Autowired
	private JdbcTemplateMemberDao jdbcTemplateMemberDao;

	public int DeleteMember(String id, MemberInfo memberInfo) throws SQLException {

		int resultCnt = 0;

		resultCnt = jdbcTemplateMemberDao.DeleteMemberInfo(id, memberInfo);

		return resultCnt;
	}

}