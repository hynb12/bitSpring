package com.bitcamp.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.gb.service.DeleteMessageService;
import com.bitcamp.gb.service.InvalidMessagePassowrdException;
import com.bitcamp.gb.service.MessageNotFoundException;
import com.bitcamp.gb.service.ServiceException;

@Controller
@RequestMapping("/guest/delete")
public class GuestBookDeleteController {

	@Autowired
	private DeleteMessageService service;

	@RequestMapping(method = RequestMethod.GET)
	public String getDeleteForm(@RequestParam("id") String id, Model model) {

		model.addAttribute("mId", id);

		return "guest/confirmDelete";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String deleteMessage(@RequestParam("messageId") int messageId, @RequestParam("password") String password) {

		String viewName = "redirect:/guest/list";

		try {

			service.deleteMessage(messageId, password);

		} catch (ServiceException e) {

			viewName = "guest/error";

		} catch (InvalidMessagePassowrdException e) {

			viewName = "redirect:/guest/delete?id=" + messageId;

		} catch (MessageNotFoundException e) {
			viewName = "redirect:/guest/list";
		}

		return viewName;
	}

}