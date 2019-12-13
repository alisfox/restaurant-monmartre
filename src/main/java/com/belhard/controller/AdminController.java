package com.belhard.controller;

import java.text.ParseException;
import java.util.List;

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
public class AdminController {

	@Autowired
	EmployeeService serv;

	@Autowired
	EmployeeVacationService servEmplVac;

	@Autowired
	EmployeeRecommendationsService servEmplRec;

	@GetMapping("/welcome")
	public ModelAndView index(HttpSession session, HttpServletRequest request) {

		ModelAndView mod = new ModelAndView("welcome");

		return mod;
	}

	@ModelAttribute(name = "employeeList")
	public List<Employee> getListEmployee() {

		List<Employee> employeeList = serv.showEmployees();

		return employeeList;
	}

	@ModelAttribute(name = "employee")
	private Employee getEmptyEmployee() {
		return new Employee();
	}

	@ModelAttribute(name = "employeeList1")
	public List<EmployeeVacation> getListEmployeeVacation(Model model) {

		List<EmployeeVacation> employeeVacList = servEmplVac.getAllEmployeeVacationsServ();

		return employeeVacList;
	}

	@ModelAttribute(name = "employeeVacation")
	private EmployeeVacation getEmptyEmployeeVacation() {
		return new EmployeeVacation();
	}

	@ModelAttribute(name = "employeeRecommendationsList")
	public List<EmployeeRecommendations> getListEmployeeRecommendations(Model model) {

		List<EmployeeRecommendations> employeeRecList = servEmplRec.getAllEmployeeRecommendationsServ();

		return employeeRecList;
	}

	@ModelAttribute(name = "employeeRecommendations")
	private EmployeeRecommendations getEmptyEmployeeRecommendations() {
		return new EmployeeRecommendations();
	}

	@RequestMapping(value = "/delete/{idEmployeeRecommendations}", method = RequestMethod.GET)
	public String deleteEmployeeRecommendations(@PathVariable("idEmployeeRecommendations") Integer id) {
		
		servEmplRec.deleteEmployeeRecommendationsServ(id);

		return "redirect:/welcome";

	}
	
	
}
