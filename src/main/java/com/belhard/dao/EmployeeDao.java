package com.belhard.dao;

import java.util.List;

import com.belhard.dao.entity.Employee;

public interface EmployeeDao {
	
	public void storeEmployee(Employee employee);

	public Employee getEmployee(String employeeLogin);

	public List<Employee> getAllEmployees();

	public String signInEmplServ(String login, String password);

}
