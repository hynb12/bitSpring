package com.bitcamp.op.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.op.model.Message;
import com.bitcamp.op.service.ServiceException;
import com.bitcamp.op.service.WriteMessageService;

@Controller
@RequestMapping("/guest/write")
public class GuestBookWriteController {

	@Autowired
	private WriteMessageService service;

	@RequestMapping(method = RequestMethod.GET)
	public String getWriteForm(Model model) {

		return "guest/writeForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String writeMessage(Message message) throws ServiceException {

		service.write(message);

		return "guest/write";
	}

}