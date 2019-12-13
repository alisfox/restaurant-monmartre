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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.belhard.dao.entity.Employee;
import com.belhard.dao.entity.EmployeeVacation;
import com.belhard.service.EmployeeService;
import com.belhard.service.EmployeeVacationService;

@Controller
public class PageEmployeeControllerForAdmin {

	@Autowired
	EmployeeService serv;

	@Autowired
	EmployeeVacationService servEmplVacation;

	@RequestMapping(value = "/page_empl_for_admin/{employeeLogin}", method = RequestMethod.GET)
	public ModelAndView getData(@PathVariable("employeeLogin") String login, Model model) {

		Employee empl = serv.showEmployee(login);

		String vacation = "";
		if (servEmplVacation.serchLogin(login)) {
			EmployeeVacation emplVacation = servEmplVacation.getEmployeeVacationByLoginServ(login);
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
		model.addAttribute("role", empl.getEmployeeRole());
		model.addAttribute("vacation", vacation);

		ModelAndView mod = new ModelAndView("page_employee_1");

		return mod;
	}

	@GetMapping("/page_empl_for_admin")
	public ModelAndView index(Model model, HttpServletRequest request, HttpSession session) {
		Object login = session.getAttribute("update");
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
		model.addAttribute("role", empl.getEmployeeRole());
		model.addAttribute("vacation", vacation);

		ModelAndView mod = new ModelAndView("page_employee_1");

		return mod;
	}

	@RequestMapping(value = "/page_empl_for_admin/update", method = RequestMethod.POST)
	public String updateData(HttpServletRequest req, HttpSession session) throws ParseException {
		session.setAttribute("update", req.getParameter("login"));
		req.getParameter("name");
		req.getParameter("surname");
		Employee empl = serv.showEmployee(req.getParameter("login"));
		EmployeeVacation emplVacation = null;
		if (servEmplVacation.serchLogin(req.getParameter("login"))) {
			emplVacation = servEmplVacation.getEmployeeVacationByLoginServ(req.getParameter("login"));

		} else
			emplVacation = new EmployeeVacation();
		emplVacation.setEmployeeLogin(req.getParameter("login"));
		emplVacation.setEmployee(empl);
		String date = req.getParameter("date of birth");
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Date date1 = inputFormat.parse(date);
		req.getParameter("profession");
		req.getParameter("salary");
		req.getParameter("email");
		req.getParameter("login");
		req.getParameter("password");
		req.getParameter("role");
		req.getParameter("vacation");

		empl.setEmployeeName(req.getParameter("name"));
		empl.setEmployeeSurname(req.getParameter("surname"));
		empl.setEmployeeDateOfBirth(date1);
		empl.setEmployeeProfession(req.getParameter("profession"));
		empl.setEmployeeSalary(req.getParameter("salary"));
		empl.setEmployeeEmail(req.getParameter("email"));
		empl.setEmployeeLogin(req.getParameter("login"));
		empl.setEmployeePassword(req.getParameter("password"));
		empl.setEmployeeRole(Integer.valueOf(req.getParameter("role")));
		emplVacation.setVacation(req.getParameter("vacation"));
		serv.saveEmployee(empl);
		servEmplVacation.saveEmployeeVacationServ(emplVacation);

		return "redirect:/page_empl_for_admin";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateDataTwo(HttpServletRequest req, HttpSession session) throws ParseException {
		session.setAttribute("update", req.getParameter("login"));
		req.getParameter("name");
		req.getParameter("surname");
		Employee empl = serv.showEmployee(req.getParameter("login"));
		EmployeeVacation emplVacation = null;
		if (servEmplVacation.serchLogin(req.getParameter("login"))) {
			emplVacation = servEmplVacation.getEmployeeVacationByLoginServ(req.getParameter("login"));

		} else
			emplVacation = new EmployeeVacation();
		emplVacation.setEmployeeLogin(req.getParameter("login"));
		emplVacation.setEmployee(empl);
		String date = req.getParameter("date of birth");
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Date date1 = inputFormat.parse(date);
		req.getParameter("profession");
		req.getParameter("salary");
		req.getParameter("email");
		req.getParameter("login");
		req.getParameter("password");
		req.getParameter("role");
		req.getParameter("vacation");

		empl.setEmployeeName(req.getParameter("name"));
		empl.setEmployeeSurname(req.getParameter("surname"));
		empl.setEmployeeDateOfBirth(date1);
		empl.setEmployeeProfession(req.getParameter("profession"));
		empl.setEmployeeSalary(req.getParameter("salary"));
		empl.setEmployeeEmail(req.getParameter("email"));
		empl.setEmployeeLogin(req.getParameter("login"));
		empl.setEmployeePassword(req.getParameter("password"));
		empl.setEmployeeRole(Integer.valueOf(req.getParameter("role")));
		emplVacation.setVacation(req.getParameter("vacation"));
		serv.saveEmployee(empl);
		servEmplVacation.saveEmployeeVacationServ(emplVacation);

		return "redirect:/page_empl_for_admin";

	}



}
