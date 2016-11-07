/**
 * Jami Schwarzwalder
 * Nov 6, 2016
 * User.java
 * User Object
 */
package edu.greenriver.it.userrecords;

/**
 * User object contains data about a user
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class User {
	private String firstName;
	private String lastName;
	private char sexAtBirth;
	private String email;
	private Address address;
	private String referredFrom;
	private Boolean isPreferredUser;

	/**
	 * Creates a new User
	 *
	 */
	public User (){
		
	}
	
	
	/**
	 * Creates a new User
	 *
	 * @param firstName firstName
	 * @param lastName lastName
	 * @param sexAtBirth sexAtBirth
	 * @param email email
	 * @param street street
	 * @param city city
	 * @param state state
	 * @param zipcode zipcode
	 * @param referredFrom referredFrom
	 * @param isPreferredUser isPreferredUser
	 * 
	 * Robert C. Martin is ashamed of Josh Archer style guide.
	 */
	public User(String firstName, String lastName, char sexAtBirth, String email, String street, String city, String state, String zipcode, String referredFrom,
			Boolean isPreferredUser) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sexAtBirth = sexAtBirth;
		this.email = email;
		this.address = new Address(street, city, state, zipcode);
		this.referredFrom = referredFrom;
		this.isPreferredUser = isPreferredUser;
	}


	/**
	 * Returns user's first name
	 * 
	 * @return user's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Adds user's first name
	 * 
	 * @param firstName user's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns user's last name
	 * 
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Adds user's last name
	 * 
	 * @param lastName user's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Adds char for user's gender
	 * 
	 * @param sexAtBirth user's gender
	 */
	public void setSexAtBirth(char sexAtBirth) {
		this.sexAtBirth = sexAtBirth;
	}

	/**
	 * Adds user's email address
	 * 
	 * @param email user's email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Builds User Address from United States
	 * 
	 * @param street user's street address
	 * @param city users's city 
	 * @param state users's state 
	 * @param zipcode user's zipcode
	 */
	public void setAddress(String street, String city, String state, String zipcode) {
		this.address = new Address(street, city, state, zipcode);
	}

	/**
	 * Adds user's url where they were referred from
	 * 
	 * @param referredFrom url from where they were referred
	 */
	public void setReferredFrom(String referredFrom) {
		this.referredFrom = referredFrom;
	}

	/**
	 * Adds user's preferred user status
	 * 
	 * @param isPreferredUser preferred user status
	 */
	public void setIsPreferredUser(Boolean isPreferredUser) {
		this.isPreferredUser = isPreferredUser;
	}

	/**
	 * Returns string with Name, email, and Preferred Status
	 * 
	 * @return string with Name, email, and Preferred Status
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(firstName);
		builder.append(' ');
		builder.append(lastName);
		builder.append(' ');
		builder.append(email);
		if (isPreferredUser) {
			builder.append(" preferred");
		}
		return builder.toString();
	}

	private class Address {
		private String street;
		private String city;
		private String state;
		private String zipcode;

		public Address(String street, String city, String state, String zipcode) {

			this.street = street;
			this.city = city;
			this.state = state;
			this.zipcode = zipcode;
		}

	}

}
