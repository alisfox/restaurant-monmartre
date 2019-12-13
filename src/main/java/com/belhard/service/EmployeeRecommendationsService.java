package com.belhard.service;

import java.util.List;

import com.belhard.dao.entity.EmployeeRecommendations;

public interface EmployeeRecommendationsService {
	
	public List<EmployeeRecommendations> getAllEmployeeRecommendationsServ();

	public EmployeeRecommendations getEmployeeRecommendationsByLoginServ(String login);

	public void deleteEmployeeRecommendationsServ(Integer id);

	public EmployeeRecommendations saveEmployeeRecommendationsServ(EmployeeRecommendations empl);

	public Boolean searchLogin(String login);

	public void insertDataEmployeeRecommendations(String logn, String recommendations);

}
