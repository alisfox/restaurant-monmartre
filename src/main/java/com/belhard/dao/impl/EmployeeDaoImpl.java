package com.belhard.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.belhard.dao.EmployeeDao;
import com.belhard.dao.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void storeEmployee(Employee employee) {
		entityManager.merge(employee);
	}

	@Override
	public Employee getEmployee(String employeeLogin) {

		return entityManager.find(Employee.class, employeeLogin);
	}

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> listEmployees = entityManager.createQuery("from Employee", Employee.class).getResultList();

		return listEmployees;
	}

	@Override
	public String signInEmplServ(String login, String password) {

		Employee empl = entityManager.find(Employee.class, login);

		if (empl != null) {
			String pass = empl.getEmployeePassword();
			Integer role = empl.getEmployeeRole();
			if (password.equals(pass) && role == 0) {
				return "level_admin";
			}
			if (password.equals(pass) && role == 2) {
				return "level_worker";

			}
			if (password.equals(pass) && role == 1) {
				return "level_blocked";

			}
		}

		return "error";
	}
}
