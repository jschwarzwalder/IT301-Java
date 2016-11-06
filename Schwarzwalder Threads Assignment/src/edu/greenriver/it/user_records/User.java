/**
 * Jami Schwarzwalder
 * Nov 6, 2016
 * User.java
 * User Records
 */
package edu.greenriver.it.user_records;

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
	private String address;
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

	public char getSexAtBirth() {
		return sexAtBirth;
	}

	public void setSexAtBirth(char sexAtBirth) {
		this.sexAtBirth = sexAtBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReferredFrom() {
		return referredFrom;
	}

	public void setReferredFrom(String referredFrom) {
		this.referredFrom = referredFrom;
	}

	public Boolean getIsPreferredUser() {
		return isPreferredUser;
	}

	public void setIsPreferredUser(Boolean isPreferredUser) {
		this.isPreferredUser = isPreferredUser;
	}

}
