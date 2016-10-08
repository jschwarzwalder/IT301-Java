package edu.greenriver.it.subsets;

import java.util.ArrayList;
import edu.greenriver.it.employee.Employee;



public class Subsets
{
	public static void main(String[] args)
	{
		//save teams with scores greater than 20
		saveTeams();
	}
	
	public static void saveTeams()
	{
		//load employee objects and then query them
		ArrayList<Employee> employees = loadEmployees();
		
		//enumerate all subsets of employees and print
		//any teams found with a collective employee
		//rating above 20
	}
	
	public static ArrayList<Employee> loadEmployees()
	{
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		//load employees from employees.dat here...
		
		return employees;
	}
}
