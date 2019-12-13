package com.belhard.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.belhard.dao.entity.Employee;
import com.belhard.service.EmployeeService;

@Controller
public class AdminControllerTwo {

	@Autowired
	EmployeeService serv;

	@GetMapping("/add_employee")
	public ModelAndView index(HttpSession session, HttpServletRequest request) {

		ModelAndView mod = new ModelAndView("add_employee");

		return mod;
	}

	@RequestMapping(value = "/save-empl", method = RequestMethod.POST)
	public ModelAndView saveEmployee(Employee empl) {

		serv.saveEmployee(empl);

		ModelAndView modelAndView = new ModelAndView("redirect:/welcome");
		return modelAndView;
	}

	@ModelAttribute(name = "employee")
	private Employee getEmptyEmployee() {
		return new Employee();
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
