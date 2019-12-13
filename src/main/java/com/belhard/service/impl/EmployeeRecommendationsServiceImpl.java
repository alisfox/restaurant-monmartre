package com.belhard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.belhard.dao.EmployeeRecommendationsDao;
import com.belhard.dao.entity.EmployeeRecommendations;
import com.belhard.service.EmployeeRecommendationsService;

@Service
@Transactional
public class EmployeeRecommendationsServiceImpl implements EmployeeRecommendationsService {

	@Autowired
	EmployeeRecommendationsDao dao;

	@Override
	public List<EmployeeRecommendations> getAllEmployeeRecommendationsServ() {

		return dao.getAllEmployeeRecommendations();
	}

	@Override
	public EmployeeRecommendations getEmployeeRecommendationsByLoginServ(String login) {

		return dao.getEmployeeRecommendationsByLogin(login);
	}

	@Override
	public void deleteEmployeeRecommendationsServ(Integer id) {

		dao.deleteEmployeeRecommendations(id);

	}

	@Override
	public EmployeeRecommendations saveEmployeeRecommendationsServ(EmployeeRecommendations empl) {

		return dao.storeEmployeeRecommendations(empl);
	}

	@Override
	public Boolean searchLogin(String login) {

		return dao.searchEmployeeRecommendationsLogin(login);
	}

	@Override
	public void insertDataEmployeeRecommendations(String login, String recommendations) {

		dao.insertInEmployeeRecommendations(login, recommendations);
	}

}
