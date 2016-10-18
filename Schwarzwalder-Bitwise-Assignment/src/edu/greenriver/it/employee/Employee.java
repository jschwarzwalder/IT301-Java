/*
 * Jami Schwarzwalder
 * 10/8/2016
 * Employee.java
 * This file stored Employee information!
 */

package edu.greenriver.it.employee;

import java.util.Date;

/**
 * This class represents an employee
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class Employee {

	private String firstName;
	private String lastName;
	private int employeeRating;
	private Date hireDate;

	/**
	 * Returns first name of Employee
	 * 
	 * @return Employee's First Name
	 * 
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Assigns First Name of Employee
	 * 
	 * @param firstName
	 *            employee's first name
	 * 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns last name of Employee
	 * 
	 * @return Employee's Last Name
	 * 
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Assigns Last Name of Employee
	 * 
	 * @param firstName
	 *            employee's last name
	 * 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns first and last name of Employee
	 * 
	 * @return Employee's Full Name
	 * 
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}

	/**
	 * Returns number Rating of Employee
	 * 
	 * @return Employee's Rating
	 * 
	 */
	public int getEmployeeRating() {
		return employeeRating;
	}

	/**
	 * Assigns number Rating of Employee
	 * 
	 * @param employeeRating
	 *            Employee's Rating
	 * 
	 */
	public void setEmployeeRating(int employeeRating) {
		this.employeeRating = employeeRating;
	}

	/**
	 * Returns Hire Date of Employee
	 * 
	 * @return Date employee was hired
	 * 
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * Assigns Hire Date of Employee
	 * 
	 * @param hireDate
	 *            Date employee hired
	 * 
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * Returns String of information about Employee
	 * 
	 * @return employee's full name, rating, and hire date
	 * 
	 */
	@Override
	public String toString() {
		return "Employee " + getFullName() + " - " + getEmployeeRating() + ". Hired: " + getHireDate();
	}

}
