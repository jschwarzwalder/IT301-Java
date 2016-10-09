/*
 * Jami Schwarzwalder
 * 10/8/2016
 * Subsets.java
 * This file builds the Teams!
 */

package edu.greenriver.it.subsets;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import edu.greenriver.it.employee.Employee;

public class Subsets {
	private static final int COLLECTIVE_SCORE_THRESHOLD = 20;
	private static File employeeFile = new File("employees.dat");
	// private static File employeeFile = new File("more_employees.dat");
	// private static File employeeFile = new File("even_more_employees.dat");

	public static void main(String[] args) {
		// save teams with scores greater than 20
		saveTeams();
	}

	public static void saveTeams() {
		// load employee objects and then query them
		ArrayList<Employee> employees = loadEmployees();

		// enumerate all subsets of employees
		for (int i = 1; i < Math.pow(2, employees.size()); i++) {
			// Team Score
			int teamRating = 0;

			// Team Members
			ArrayList<Employee> team = new ArrayList<Employee>();

			// store index of employee
			int index = 0;
			// set the mask for each bit
			for (int mask = 1; mask < Math.pow(2, employees.size()); mask *= 2) {
				int maskCheck = i & mask;
				// if employee in that combination, add rating
				if (maskCheck > 0) {
					// add Rating to Team Rating
					Employee teammember = employees.get(index);
					teamRating += teammember.getEmployeeRating();

					// add Employee to team
					team.add(teammember);
				}

				// increase index
				index += 1;

			}

			// and print any teams found with a collective employee
			// rating above 20
			if (teamRating > COLLECTIVE_SCORE_THRESHOLD) {

				System.out.println("Team found (score: " + teamRating + ")");

				for (int j = 0; j < team.size(); j++) {
					// Get employee
					Employee teammember = team.get(j);

					// print out employee's name
					System.out.print(teammember.getFullName());
					System.out.print(" - ");

					// print out employee's rating
					System.out.print(teammember.getEmployeeRating());
					System.out.println();

				}

				// line break between teams
				System.out.println();

			}
		}

	}

	/**
	 * Adds Employee data from file to employee Array List
	 * 
	 * @return ArrayList<Employee> of Employees from employee
	 * 
	 */
	public static ArrayList<Employee> loadEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>();

		// load employees from employees.dat here...
		try {
			Scanner scan = new Scanner(employeeFile);

			while (scan.hasNextLine()) {
				String oneEmployee = scan.nextLine();
				String[] employeeScannedFields = oneEmployee.split(",");

				// create Employee
				Employee scannedEmployee = new Employee();

				// Read First and Last Name
				String[] employeeName = employeeScannedFields[0].split(" ");
				scannedEmployee.setFirstName(employeeName[0].trim());
				scannedEmployee.setLastName(employeeName[1].trim());

				// Read Rating
				scannedEmployee.setEmployeeRating(Integer.parseInt(employeeScannedFields[1].trim()));

				// Read Hire Date
				DateFormat dateParser = new SimpleDateFormat("M/d/yyyy");
				scannedEmployee.setHireDate(dateParser.parse(employeeScannedFields[2].trim()));

				// add employee to ArrayList
				employees.add(scannedEmployee);
				// System.out.println(scannedEmployee);

			}

			scan.close();

		} catch (FileNotFoundException e) {
			// If file not found print call stack
			e.printStackTrace();
		} catch (ParseException e) {
			// If Date does not convert correctly print call stack
			e.printStackTrace();
		}

		return employees;
	}

}
