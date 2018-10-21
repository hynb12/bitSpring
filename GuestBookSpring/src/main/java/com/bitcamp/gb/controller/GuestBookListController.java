package com.bitcamp.gb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.gb.model.MessageListView;
import com.bitcamp.gb.service.GetMessageListService;
import com.bitcamp.gb.service.ServiceException;

@Controller
public class GuestBookListController {

	@Autowired
	private GetMessageListService service;

	@RequestMapping("/guest/list") // /guest/list?page=1
	public ModelAndView getGuestList(HttpServletRequest request) throws ServiceException {

		String pageNumberStr = request.getParameter("page");

		int pageNumber = 1;
		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		MessageListView viewData = service.getMessageList(pageNumber);

		ModelAndView modelAndView = new ModelAndView();

		// viewName 설정
		modelAndView.setViewName("guest/list");

		// view 에 결과 데이터를 전달(공유)
		modelAndView.addObject("viewData", viewData);

		return modelAndView;

	}

	/*
	 * @RequestMapping("/guestbook/list") public ModelAndView getList(
	 * 
	 * @RequestParam(value="page", defaultValue="1") int pageNumber) throws
	 * ServiceException {
	 * 
	 * ModelAndView modelAndView = new ModelAndView();
	 * 
	 * modelAndView.setViewName("guestbook/list");
	 * 
	 * MessageListView listView = service.getMessageList(pageNumber);
	 * 
	 * modelAndView.addObject("listView", listView);
	 * 
	 * return modelAndView;
	 * 
	 * }
	 */

}