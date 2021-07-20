package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {

		System.out.println("[GuestbookController.LIST]");

		GuestbookDao guestbookDao = new GuestbookDao();

		List<GuestbookVo> guestList = guestbookDao.getGuestbookList();

		model.addAttribute("guestList", guestList);

		return "/WEB-INF/list.jsp";

	}

	@RequestMapping(value = "/INSERT", method = { RequestMethod.GET, RequestMethod.POST })

	public String write(@ModelAttribute GuestbookVo guestbookVo) {

		System.out.println("[GuestbookController.INSERT]");

		System.out.println(guestbookVo);

		GuestbookDao guestbookDao = new GuestbookDao();

		guestbookDao.guestbookInsert(guestbookVo);

		return "redirect:/list";

	}

	@RequestMapping(value = "/deleteForm", method = { RequestMethod.GET, RequestMethod.POST })

	public String deleteForm(@RequestParam("personId") int personId, @RequestParam("password") String password) {

		System.out.println("[PhoneController.DELETEFORM]");

		GuestbookDao guestbookDao = new GuestbookDao();

		guestbookDao.guestbookDelete(personId, password);

		return "/WEB-INF/views/deleteForm.jsp";

	}

	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })

	public String delete(@RequestParam("personId") int personId, @RequestParam("password") String password) {

		System.out.println("[PhoneController.DELETE]");

		GuestbookDao guestbookDao = new GuestbookDao();

		guestbookDao.guestbookDelete(personId, password);

		return "redirect:/list";

	}

}