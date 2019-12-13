package com.belhard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.belhard.dao.EmployeeDao;
import com.belhard.dao.entity.Employee;
import com.belhard.service.EmployeeService;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao dao;

	@Override
	public String signInEmployeeServ(String login, String password) {

		return dao.signInEmplServ(login, password);
	}

	@Override
	public List<Employee> showEmployees() {

		return dao.getAllEmployees();
	}

	@Override
	public Employee showEmployee(String login) {

		return dao.getEmployee(login);
	}

	@Override
	public void saveEmployee(Employee empl) {

		dao.storeEmployee(empl);
	}

	


}
