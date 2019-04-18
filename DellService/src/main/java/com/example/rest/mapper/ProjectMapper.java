package com.example.rest.mapper;

import java.util.List;

import com.example.rest.model.AddProject;
import com.example.rest.model.Project;

public interface ProjectMapper {

	public List<Project> getAllProject();

	public Project getProjectById(Integer projectId);

	public void addProjects(AddProject addProject);

	public void updateProject(AddProject addProject);

	public void deleteProject(Integer projectId);

	public List<Project> getprojectByManagerId(Integer managerId);

	public AddProject getProject(AddProject addProject);

}
