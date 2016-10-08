package edu.greenriver.it.subsets;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import edu.greenriver.it.employee.Employee;

public class Subsets {
	private static File employeeFile = new File("employees.dat");
	
	public static void main(String[] args) {
		// save teams with scores greater than 20
		saveTeams();
	}

	public static void saveTeams() {
		// load employee objects and then query them
		ArrayList<Employee> employees = loadEmployees();

		// enumerate all subsets of employees 
		for (int i = 0; i < Math.pow(2, employees.size()); i ++ ){
			int teamRating = 0;
			//store index of employee
			int index = 0;
			//set the mask for each bit 
			for (int mask= 1; mask < Math.pow(2, employees.size()); mask*=2) {
				int maskCheck = i & mask;
				//if employee in that combination, add rating 
				if (maskCheck > 0){
					Employee teammember = employees.get(index);
					teamRating += teammember.getEmployeeRating();
					
					//if team collective scores over 20 move to next combination
					if (teamRating > 20){
						break;
					}
				}
				
				//increase index
				index += 1;
				
			}
			
			// and print any teams found with a collective employee
			// rating above 20
			if (teamRating > 20) {
				
				//printTeam(i, teamRating);
				
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
			
			while (scan.hasNextLine()){
				String oneEmployee = scan.nextLine();
				String[] employeeScannedFields = oneEmployee.split(",");
								
				//create Employee
				Employee scannedEmployee = new Employee();
				
				//Read First and Last Name
				String[] employeeName = employeeScannedFields[0].split(" ");
				scannedEmployee.setFirstName(employeeName[0].trim());
				scannedEmployee.setLastName(employeeName[1].trim());
				
				//Read Rating
				scannedEmployee.setEmployeeRating(Integer.parseInt(employeeScannedFields[1].trim()));
				
				//Read Hire Date				
				DateFormat dateParser = new SimpleDateFormat("M/d/yyyy");
				scannedEmployee.setHireDate(dateParser.parse(employeeScannedFields[2].trim()));
				
				//add employee to ArrayList
				employees.add(scannedEmployee);
				System.out.println(scannedEmployee);
							
			}
			
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
