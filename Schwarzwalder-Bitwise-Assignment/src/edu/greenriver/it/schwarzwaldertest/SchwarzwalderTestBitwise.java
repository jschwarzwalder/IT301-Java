/*
 * Jami Schwarzwalder
 * 10/8/2016
 * SchwarzwalderTestBitwise.java
 * This file tests Employee and Subsets Classes!
 */

package edu.greenriver.it.schwarzwaldertest;

import edu.greenriver.it.subsets.Subsets;


/**
 * This class tests Employee and Subsets Classes
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class SchwarzwalderTestBitwise {

	/**
	 * Loads Employees and Creates teams
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Subsets.loadEmployees();
		Subsets.saveTeams();
	}

}
