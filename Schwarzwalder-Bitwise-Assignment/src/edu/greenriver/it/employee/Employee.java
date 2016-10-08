package edu.greenriver.it.employee;

import java.util.Date;

public class Employee {

	private String firstName;
	private String lastName;
	private int employeeRating;
	private Date hireDate;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public int getEmployeeRating() {
		return employeeRating;
	}

	public void setEmployeeRating(int employeeRating) {
		this.employeeRating = employeeRating;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

}
