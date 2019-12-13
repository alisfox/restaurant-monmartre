package com.belhard.controller;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.HttpJspPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.belhard.service.EmployeeService;

@Controller
public class FirstController {

	@Autowired
	EmployeeService serv;

	@GetMapping("/")
	public ModelAndView index(HttpSession session, HttpServletRequest request) {

		ModelAndView mod = new ModelAndView("login");

		return mod;
	}

	@GetMapping("/errorSign")
	public ModelAndView indexTwo() {

		ModelAndView mod = new ModelAndView("login");
		mod.addObject("error", "Wrong login or password!");

		return mod;
	}

	@GetMapping("/block")
	public ModelAndView indexThree() {

		ModelAndView mod = new ModelAndView("login");
		mod.addObject("block", "Your account is block!");

		return mod;
	}

	@PostMapping("/action")
	public String signInEmployee(HttpServletRequest request, HttpSession session) throws NoSuchElementException {

		String level;
		String str = null;
		String login = request.getParameter("employee_login");
		String password = request.getParameter("employee_password");
		session.setAttribute("login", login);
		level = serv.signInEmployeeServ(login, password);

		if ("error".equals(level)) {
			str = "redirect:/errorSign";

		}

		if ("level_admin".equals(level)) {
			str = "redirect:/welcome";

		}

		if ("level_worker".equals(level)) {
			str = "redirect:/page_empl";
		}

		if ("level_blocked".equals(level)) {
			str = "redirect:/block";
		}

		return str;

	}

}
