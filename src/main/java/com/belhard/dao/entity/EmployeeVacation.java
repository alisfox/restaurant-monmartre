package com.belhard.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_VACATION")

public class EmployeeVacation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "employee_login", updatable = false, insertable = false)
	private String employeeLogin;

	@Column(name = "vacation")
	private String vacation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_login")
	private Employee employee;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getVacation() {
		return vacation;
	}

	public void setVacation(String vacation) {
		this.vacation = vacation;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		EmployeeVacation other = (EmployeeVacation) obj;
		if (employeeLogin == null) {
			if (other.employeeLogin != null)
				return false;
		} else if (!employeeLogin.equals(other.employeeLogin))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeVacation [id=" + id + ", employeeLogin=" + employeeLogin + ", vacation=" + vacation
				+ ", employee=" + employee + "]";
	}

	public String getEmployeeLogin() {
		return employeeLogin;
	}

	public void setEmployeeLogin(String employeeLogin) {
		this.employeeLogin = employeeLogin;
	}

	

}
