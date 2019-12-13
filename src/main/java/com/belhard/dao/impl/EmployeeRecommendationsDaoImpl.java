package com.belhard.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.belhard.dao.EmployeeRecommendationsDao;
import com.belhard.dao.entity.EmployeeRecommendations;

@Repository
public class EmployeeRecommendationsDaoImpl implements EmployeeRecommendationsDao {

	@Autowired
	EntityManager entityManager;

	@Transactional
	public EmployeeRecommendations storeEmployeeRecommendations(EmployeeRecommendations empl) {

		entityManager.merge(empl);

		return empl;

	}

	@Override
	public void deleteEmployeeRecommendations(Integer id) {

		/*Query q = entityManager.createNativeQuery(
				"SELECT a.id_employee_recommendations FROM Employee_Recommendations a WHERE a.employee_login = :employee_login");
		q.setParameter("employee_login", login);
		Integer id = (Integer) q.getSingleResult();*/

		EmployeeRecommendations empl = entityManager.find(EmployeeRecommendations.class, id);
		entityManager.remove(empl);

	}

	@Override
	public EmployeeRecommendations getEmployeeRecommendationsByLogin(String login) {

		Query q = entityManager.createNativeQuery(
				"SELECT a.id_employee_recommendations FROM Employee_Recommendations a WHERE a.employee_login = :employee_login");
		q.setParameter("employee_login", login);
		Integer id = (Integer) q.getSingleResult();

		return entityManager.find(EmployeeRecommendations.class, id);

	}

	@Override
	public List<EmployeeRecommendations> getAllEmployeeRecommendations() {
		List<EmployeeRecommendations> list = entityManager
				.createQuery("from EmployeeRecommendations", EmployeeRecommendations.class).getResultList();
		return list;
	}

	@Override
	public Boolean searchEmployeeRecommendationsLogin(String login) {
		Boolean f = true;

		Query q = entityManager.createNativeQuery(
				"SELECT Count(a.id_employee_recommendations) FROM Employee_Recommendations a WHERE a.employee_login = :employee_login");
		q.setParameter("employee_login", login);
		BigInteger id = (BigInteger) q.getSingleResult();
		int idInt = id.intValue();
		if (idInt == 0) {
			f = false;
		}

		return f;
	}

	@Transactional
	public void insertInEmployeeRecommendations(String login, String message) {

		Query query = entityManager.createNativeQuery(
				"INSERT INTO employee_recommendations (employee_login, recommendations) VALUES (?, ?)");
		query.setParameter(1, login);
		query.setParameter(2, message);
		query.executeUpdate();
		
	}

}
