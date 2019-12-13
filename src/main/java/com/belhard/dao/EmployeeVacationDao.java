package com.belhard.dao;

import java.util.List;

import com.belhard.dao.entity.EmployeeVacation;

public interface EmployeeVacationDao {

	public EmployeeVacation storeEmployeeVacation(EmployeeVacation emplVac);

	public EmployeeVacation getEmployeeVacationByLogin(String employeeLogin);

	public List<EmployeeVacation> getAllEmployeeVacations();

	public Boolean searchEmployeeVacationLogin(String login);

}
