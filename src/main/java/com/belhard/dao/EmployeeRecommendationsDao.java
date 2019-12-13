package com.belhard.dao;

import java.util.List;

import com.belhard.dao.entity.EmployeeRecommendations;

public interface EmployeeRecommendationsDao {

	public EmployeeRecommendations storeEmployeeRecommendations(EmployeeRecommendations empl);

	public void deleteEmployeeRecommendations(Integer id);

	public EmployeeRecommendations getEmployeeRecommendationsByLogin(String login);

	public List<EmployeeRecommendations> getAllEmployeeRecommendations();

	public Boolean searchEmployeeRecommendationsLogin(String login);

	public void insertInEmployeeRecommendations(String login, String message);
}
