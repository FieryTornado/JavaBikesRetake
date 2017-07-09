package model;

import database.ReadAndWrite;

public class Customer {
	
	private String firstName, lastName, username, password;
	
	//Contructor for customer object
	public Customer() {
		}
	
	//File to write customer details to
	public void writeToFile(String details) {
		ReadAndWrite.writeDetails("Customer.txt", details);
	}

	//Getters and Setters
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}