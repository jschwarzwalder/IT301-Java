package edu.greenriver.it.employee;

import java.util.Date;

public class Employee {

	private String firstName;
	private String lastName;
	private int employeeRating;
	private Date hireDate;

	/**
	 * Returns first name of Employee
	 * 
	 * @return String Employees First Name
	 * 
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Assigns First Name of Employee
	 * 
	 * @param firstName
	 *            String employee's first name
	 * 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns last name of Employee
	 * 
	 * @return String Employees Last Name
	 * 
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Assigns Last Name of Employee
	 * 
	 * @param firstName
	 *            String employee's last name
	 * 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns first and last name of Employee
	 * 
	 * @return String Employees Full Name
	 * 
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}

	/**
	 * Returns number Rating of Employee
	 * 
	 * @return int Employees Rating
	 * 
	 */
	public int getEmployeeRating() {
		return employeeRating;
	}

	/**
	 * Assigns number Rating of Employee
	 * 
	 * @param employeeRating
	 *            int Employees Rating
	 * 
	 */
	public void setEmployeeRating(int employeeRating) {
		this.employeeRating = employeeRating;
	}

	/**
	 * Returns Hire Date of Employee
	 * 
	 * @return Date employee hired
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
	 * @return  String employee's full name, rating, and hire date
	 * 
	 */
	@Override
	public String toString() {
		return "Employee " + getFullName() + " - " + getEmployeeRating() + ". Hired: " + getHireDate();
	}

}
