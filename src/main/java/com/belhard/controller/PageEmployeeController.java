package com.belhard.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.belhard.dao.entity.Employee;
import com.belhard.dao.entity.EmployeeRecommendations;
import com.belhard.dao.entity.EmployeeVacation;
import com.belhard.service.EmployeeRecommendationsService;
import com.belhard.service.EmployeeService;
import com.belhard.service.EmployeeVacationService;

@Controller
public class PageEmployeeController {

	@Autowired
	EmployeeService serv;

	@Autowired
	EmployeeVacationService servEmplVacation;

	@Autowired
	EmployeeRecommendationsService servEmplRecommendations;
	

	@GetMapping("/page_empl")
	public ModelAndView getDataEmployee(HttpSession session, Model model) {
		Object login = (String) session.getAttribute("login");
		String strLogin = String.valueOf(login);
		Employee empl = serv.showEmployee(strLogin);
		String vacation = "";
		if (servEmplVacation.serchLogin(strLogin)) {
			EmployeeVacation emplVacation = servEmplVacation.getEmployeeVacationByLoginServ(strLogin);
			vacation = emplVacation.getVacation();
		}

		model.addAttribute("name", empl.getEmployeeName());
		model.addAttribute("surname", empl.getEmployeeSurname());
		model.addAttribute("date", empl.getEmployeeDateOfBirth());
		model.addAttribute("profession", empl.getEmployeeProfession());
		model.addAttribute("salary", empl.getEmployeeSalary());
		model.addAttribute("email", empl.getEmployeeEmail());
		model.addAttribute("login", empl.getEmployeeLogin());
		model.addAttribute("password", empl.getEmployeePassword());

		model.addAttribute("vacation", vacation);

		ModelAndView mod = new ModelAndView("page_employee");
		return mod;

	}
	
	@RequestMapping(value = "/email", method = RequestMethod.POST)
	public String updateEmailEmployee(HttpServletRequest req) {
		req.getParameter("email");
		req.getParameter("login");
		Employee empl = serv.showEmployee(req.getParameter("login"));
		empl.setEmployeeEmail(req.getParameter("email"));
		serv.saveEmployee(empl);
		return "redirect:/page_empl";

	}

	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public String sendMessageEmployee(HttpServletRequest req) {
		req.getParameter("message");
		req.getParameter("login");
		Employee empl = serv.showEmployee(req.getParameter("login"));
		EmployeeRecommendations e = new EmployeeRecommendations();
		e.setEmployeeLogin(req.getParameter("login"));
		e.setRecommendations(req.getParameter("message"));
		e.setEmployee(empl);
		servEmplRecommendations.saveEmployeeRecommendationsServ(e);
		
		return "redirect:/page_empl";

	}

	
}
