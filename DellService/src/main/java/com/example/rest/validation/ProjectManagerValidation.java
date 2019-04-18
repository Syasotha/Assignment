package com.example.rest.validation;

import com.example.rest.model.ProjectManager;
import com.example.rest.services.ProjectManagerServices;

public class ProjectManagerValidation {
	// ********************************************************************************************************
	public static boolean isProjectManagerAvailable(ProjectManager projectManager) {
		ProjectManager excistsObject = new ProjectManagerServices().getProjectManager(projectManager);
		if (excistsObject == null) {
			return true;
		} else {
			return false;
		}
	}

	// *********************************************************************************************************
	public static boolean isProjectManagerNotEmpty(ProjectManager projectManager) {
		if ((projectManager.getEmail() == null) && (projectManager.getName() == null)
				&& (projectManager.getContactNumber() == null)) {
			return true;
		} else {
			return false;
		}
	}

}
