package com.example.rest.mapper;

import java.util.List;

import com.example.rest.model.ProjectManager;

public interface ProjectManagerMapper {
	public List<ProjectManager> findAll();

	public void insertProjectManager(ProjectManager projectManager);

	public void updateProjectManager(ProjectManager projectManager);

	public void deleteProjectManager(Integer projectManagerId);

	public ProjectManager getProjectManagerById(Integer projectManagerId);

	boolean editProjectManager(ProjectManager projectManager, Integer projectManagerId);

	public ProjectManager getProjectManager(ProjectManager projectManager);

	// boolean deleteProjectManagerById(Integer projectManagerId);
}
