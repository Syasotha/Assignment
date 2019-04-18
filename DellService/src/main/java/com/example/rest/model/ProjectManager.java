package com.example.rest.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ProjectManager {

	private int id;
	@NotNull
	@Valid
	private String name;
	private String email;
	private String contactNumber;

	@Override
	public String toString() {
		return "ProjectManager [id=" + id + ", name=" + name + ", email=" + email + ", contactNumber=" + contactNumber
				+ "]";
	}

	// setters and getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public boolean validate() {
		if (this.name == null) {
			return false;
		}
		return true;
	}

}
