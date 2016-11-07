/**
 * Jami Schwarzwalder
 * Nov 6, 2016
 * User.java
 * User Records
 */
package edu.greenriver.it.userrecords;

/**
 * User Records contains data about users
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

	public void setSexAtBirth(char sexAtBirth) {
		this.sexAtBirth = sexAtBirth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String street, String city, String state, String zipcode) {
		this.address = new Address(street, city, state, zipcode);
	}

	public void setReferredFrom(String referredFrom) {
		this.referredFrom = referredFrom;
	}

	public void setIsPreferredUser(Boolean isPreferredUser) {
		this.isPreferredUser = isPreferredUser;
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
