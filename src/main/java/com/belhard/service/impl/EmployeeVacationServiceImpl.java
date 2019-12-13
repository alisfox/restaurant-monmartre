package com.belhard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.belhard.dao.EmployeeVacationDao;
import com.belhard.dao.entity.EmployeeVacation;
import com.belhard.service.EmployeeVacationService;

@Service
@Transactional
public class EmployeeVacationServiceImpl implements EmployeeVacationService {

	@Autowired
	EmployeeVacationDao dao;

	@Override
	public List<EmployeeVacation> getAllEmployeeVacationsServ() {

		return dao.getAllEmployeeVacations();
	}

	@Override
	public EmployeeVacation getEmployeeVacationByLoginServ(String login) {

		return dao.getEmployeeVacationByLogin(login);
	}

	@Override
	public Boolean serchLogin(String login) {

		return dao.searchEmployeeVacationLogin(login);
	}

	@Override
	public EmployeeVacation saveEmployeeVacationServ(EmployeeVacation emplVac) {
		
		return dao.storeEmployeeVacation(emplVac);
	}

}
