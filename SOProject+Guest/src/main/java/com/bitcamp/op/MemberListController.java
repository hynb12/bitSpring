package com.bitcamp.op;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.op.member.model.MemberInfo;
import com.bitcamp.op.member.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	MemberListService memberListService;

	@RequestMapping("/member/list")
	public ModelAndView getMemberList() throws Exception {

		List<MemberInfo> viewData = memberListService.memberList();

		ModelAndView mav = new ModelAndView();

		mav.addObject("list", viewData);
		mav.setViewName("member/list");

		return mav;

	}

}