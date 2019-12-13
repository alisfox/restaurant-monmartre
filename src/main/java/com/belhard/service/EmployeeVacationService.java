package com.belhard.service;

import java.util.List;

import com.belhard.dao.entity.EmployeeVacation;

public interface EmployeeVacationService {

	public List<EmployeeVacation> getAllEmployeeVacationsServ();

	public EmployeeVacation getEmployeeVacationByLoginServ(String login);

	public Boolean serchLogin(String login);
	
	public EmployeeVacation saveEmployeeVacationServ(EmployeeVacation emplVac);

}
