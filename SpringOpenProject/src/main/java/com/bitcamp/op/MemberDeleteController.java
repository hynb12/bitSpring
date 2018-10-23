package com.bitcamp.op;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.op.member.model.MemberInfo;
import com.bitcamp.op.member.service.MemberDeleteService;

@Controller
public class MemberDeleteController {

	@Autowired
	private MemberDeleteService memberDeleteService;

	@RequestMapping("/member/delete")
	public ModelAndView modifyProcess(@RequestParam("userId") String id, MemberInfo member) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("member/deleteOk");

		try {

			int resultCnt = memberDeleteService.DeleteMember(id, member);

			if (resultCnt == 0) {
				modelAndView.setViewName("member/deleteFail");
			}

		} catch (IllegalStateException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modelAndView;
	}

}