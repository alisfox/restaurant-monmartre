package com.belhard.service;

import java.util.List;

import com.belhard.dao.entity.Employee;

public interface EmployeeService {
	
	public String signInEmployeeServ(String id, String password);

	public List<Employee> showEmployees();
	
	public Employee showEmployee(String login);
	
	public void saveEmployee(Employee empl);

}
