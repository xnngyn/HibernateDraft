package de.hft_stuttgart.source;

import java.io.PrintStream;

public class Employee {

	private int id;

	private String firstName;

	private String lastName;

	public Employee() {
	};

	public Employee(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public String toString() {

		return String.format("%10d %10s %10s \n", id, firstName, lastName);
	}

}
