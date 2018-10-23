package com.bitcamp.op;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.op.member.model.MemberInfo;
import com.bitcamp.op.member.service.MemberModifyService;

@Controller
@RequestMapping("/member/modify")
public class MemberModifyController {

	@Autowired
	private MemberModifyService memberModifyService;

	// @RequestMapping("/member/login")
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getModifyForm(@RequestParam("userId") String id) throws SQLException {

		MemberInfo bmi = memberModifyService.getMemberBefore(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/modifyForm");
		modelAndView.addObject("bmi", bmi);

		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView modifyProcess(MemberInfo member, HttpServletRequest request) {
		System.out.println("1");
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("member/modifyOk");

		try {
			System.out.println("2");
			int resultCnt = memberModifyService.getMemberAfter(member, request);

			if (resultCnt == 0) {
				modelAndView.setViewName("member/modifyFail");
			}

		} catch (IllegalStateException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modelAndView;
	}

}