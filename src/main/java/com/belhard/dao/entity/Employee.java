package com.belhard.dao.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "employee_surname")
	private String employeeSurname;

	@Column(name = "employee_date_of_birth")

	private Date employeeDateOfBirth;

	@Column(name = "employee_profession")
	private String employeeProfession;

	@Column(name = "employee_salary")
	private String employeeSalary;

	@Column(name = "employee_email")
	private String employeeEmail;

	@Id
	@Column(name = "employee_login")
	private String employeeLogin;

	@Column(name = "employee_password")
	private String employeePassword;

	@Column(name = "employee_role")
	private Integer employeeRole;

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeSurname=" + employeeSurname
				+ ", employeeDateOfBirth=" + employeeDateOfBirth + ", employeeProfession=" + employeeProfession
				+ ", employeeSalary=" + employeeSalary + ", employeeEmail=" + employeeEmail + ", employeeLogin="
				+ employeeLogin + ", employeePassword=" + employeePassword + ", employeeRole=" + employeeRole
				+ ", employeeVacation=" + employeeVacation + ", employeeRecommendations=" + employeeRecommendations
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeEmail == null) ? 0 : employeeEmail.hashCode());
		result = prime * result + ((employeeLogin == null) ? 0 : employeeLogin.hashCode());
		result = prime * result + ((employeePassword == null) ? 0 : employeePassword.hashCode());
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
		Employee other = (Employee) obj;
		if (employeeEmail == null) {
			if (other.employeeEmail != null)
				return false;
		} else if (!employeeEmail.equals(other.employeeEmail))
			return false;
		if (employeeLogin == null) {
			if (other.employeeLogin != null)
				return false;
		} else if (!employeeLogin.equals(other.employeeLogin))
			return false;
		if (employeePassword == null) {
			if (other.employeePassword != null)
				return false;
		} else if (!employeePassword.equals(other.employeePassword))
			return false;
		return true;
	}

	public List<EmployeeRecommendations> getEmployeeRecommendations() {
		return employeeRecommendations;
	}

	public void setEmployeeRecommendations(List<EmployeeRecommendations> employeeRecommendations) {
		this.employeeRecommendations = employeeRecommendations;
	}

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private List<EmployeeVacation> employeeVacation;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private List<EmployeeRecommendations> employeeRecommendations;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeSurname() {
		return employeeSurname;
	}

	public void setEmployeeSurname(String employeeSurname) {
		this.employeeSurname = employeeSurname;
	}

	public Date getEmployeeDateOfBirth() {
		return employeeDateOfBirth;
	}

	public void setEmployeeDateOfBirth(Date employeeDateOfBirth) {
		this.employeeDateOfBirth = employeeDateOfBirth;
	}

	public String getEmployeeProfession() {
		return employeeProfession;
	}

	public void setEmployeeProfession(String employeeProfession) {
		this.employeeProfession = employeeProfession;
	}

	public String getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(String employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeLogin() {
		return employeeLogin;
	}

	public void setEmployeeLogin(String employeeLogin) {
		this.employeeLogin = employeeLogin;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public Integer getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(Integer employeeRole) {
		this.employeeRole = employeeRole;
	}

	public List<EmployeeVacation> getEmployeeVacation() {
		return employeeVacation;
	}

	public void setEmployeeVacation(List<EmployeeVacation> employeeVacation) {
		this.employeeVacation = employeeVacation;
	}

}
