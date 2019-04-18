package com.example.rest.model;

import javax.validation.constraints.NotNull;

public class AddEmployee {
	
	@NotNull(message = "Name cannot be null")
	private int id;
	private String employeeName;
	private String salary;
	private String email;
	private int projectId;

	@Override
	public String toString() {
		return "AddEmployee [id=" + id + ", employeeName=" + employeeName + ", salary=" + salary + ", email=" + email
				+ ", projectId=" + projectId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

}
