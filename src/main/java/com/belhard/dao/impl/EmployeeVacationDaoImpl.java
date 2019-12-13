package com.belhard.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.belhard.dao.EmployeeVacationDao;
import com.belhard.dao.entity.EmployeeVacation;

@Repository
public class EmployeeVacationDaoImpl implements EmployeeVacationDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public EmployeeVacation storeEmployeeVacation(EmployeeVacation emplVac) {
		entityManager.merge(emplVac);

		return emplVac;

	}

	@Override
	public EmployeeVacation getEmployeeVacationByLogin(String employeeLogin) {

		Query q = entityManager
				.createNativeQuery("SELECT a.id FROM Employee_Vacation a WHERE a.employee_login = :employee_login");
		q.setParameter("employee_login", employeeLogin);
		Integer id = (Integer) q.getSingleResult();

		return entityManager.find(EmployeeVacation.class, id);

	}

	@Override
	public List<EmployeeVacation> getAllEmployeeVacations() {
		List<EmployeeVacation> list = entityManager.createQuery("from EmployeeVacation", EmployeeVacation.class)
				.getResultList();
		return list;
	}

	@Override
	public Boolean searchEmployeeVacationLogin(String login) {
		Boolean f = true;

		Query q = entityManager.createNativeQuery(
				"SELECT Count(a.id) FROM Employee_Vacation a WHERE a.employee_login = :employee_login");
		q.setParameter("employee_login", login);
		BigInteger id = (BigInteger) q.getSingleResult();
		int idInt = id.intValue();
		if (idInt == 0) {
			f = false;
		}

		return f;
	}

}
