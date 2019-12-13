package com.belhard.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_RECOMMENDATIONS")
public class EmployeeRecommendations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_employee_recommendations", updatable = false, nullable = false)
	private Integer idEmployeeRecommendations;

	@Column(name = "employee_login", insertable=false, updatable= false)
	private String employeeLogin;

	@Column(name = "recommendations")
	private String recommendations;

	public EmployeeRecommendations() {

	}

	@ManyToOne
	@JoinColumn(name = "employee_login")
	private Employee employee;

	public Integer getIdEmployeeRecommendations() {
		return idEmployeeRecommendations;
	}

	public void setIdEmployeeRecommendations(Integer idEmployeeRecommendations) {
		this.idEmployeeRecommendations = idEmployeeRecommendations;
	}

	public String getEmployeeLogin() {
		return employeeLogin;
	}

	public void setEmployeeLogin(String employeeLogin) {
		this.employeeLogin = employeeLogin;
	}

	public String getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeLogin == null) ? 0 : employeeLogin.hashCode());
		result = prime * result + ((idEmployeeRecommendations == null) ? 0 : idEmployeeRecommendations.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeRecommendations other = (EmployeeRecommendations) obj;
		if (employeeLogin == null) {
			if (other.employeeLogin != null)
				return false;
		} else if (!employeeLogin.equals(other.employeeLogin))
			return false;
		if (idEmployeeRecommendations == null) {
			if (other.idEmployeeRecommendations != null)
				return false;
		} else if (!idEmployeeRecommendations.equals(other.idEmployeeRecommendations))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeRecommendations [idEmployeeRecommendations=" + idEmployeeRecommendations + ", employeeLogin="
				+ employeeLogin + ", recommendations=" + recommendations + ", employee=" + employee + "]";
	}

}
