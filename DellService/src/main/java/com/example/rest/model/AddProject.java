package com.example.rest.model;

public class AddProject {
	private int id;
	private String projectName;
	private String location;
	private int managerId;

	@Override
	public String toString() {
		return "AddProject [id=" + id + ", projectName=" + projectName + ", location=" + location + ", managerId="
				+ managerId + "]";
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
