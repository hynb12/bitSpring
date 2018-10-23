package com.bitcamp.op.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.model.MemberInfo;

public class MemberListService {

	@Autowired
	private JdbcTemplateMemberDao memberDao;

	public List<MemberInfo> memberList() throws Exception {

//		Connection conn = ConnectionProvider.getConnection();

		List<MemberInfo> li = memberDao.getMemberAll();

//		conn.close();

		return li;

//		ModelAndView modelAndView = new ModelAndView();
//
//		// viewName 설정
//		modelAndView.setViewName("member/list");
//
//		// view 에 결과 데이터를 전달(공유)
//		modelAndView.addObject("listData", viewData);
//
//		return modelAndView;

	}

}