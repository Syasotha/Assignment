package com.example.rest.validation;

import com.example.rest.model.AddProject;
import com.example.rest.services.ProjectServices;

public class ProjectValidation {

	public static boolean isProjectAvalibility(AddProject addProject) {
		AddProject excistsObject = new ProjectServices().getProject(addProject);
		if (excistsObject == null) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean isProjectNullChecking(AddProject addProject) {
		if ((addProject.getProjectName() == null) && (addProject.getLocation() == null)) {
			return true;
		} else {
			return false;
		}

	}

}
