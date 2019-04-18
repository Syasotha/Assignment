package com.example.rest.model;

public class Project {
	private int id;
	private String projectName;
	private String location;
	private ProjectManager managerId;

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", location=" + location + ", managerId="
				+ managerId + "]";
	}

	public ProjectManager getManagerId() {
		return managerId;
	}

	public void setManagerId(ProjectManager managerId) {
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
