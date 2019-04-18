package com.example.rest.test;

import com.example.rest.model.ProjectManager;
import com.example.rest.validation.ProjectManagerValidation;

public class ProjectManagerTest {
	public static void main(String[] args) {
		getProjectManager();
		//validationTest();
	}

	private static void validationTest() {
		ProjectManager projectManager = new ProjectManager();
		System.out.println(ProjectManagerValidation.isProjectManagerAvailable(projectManager));
	}

	private static void getProjectManager() {
		ProjectManager pm2 = new ProjectManager();
		pm2.setId(1);
		pm2.setName("Yasotha");
		pm2.setEmail("syaso@gmail.com");
		pm2.setContactNumber("0775678936");

		if (ProjectManagerValidation.isProjectManagerAvailable(pm2)) {

			System.out.println("save");
		} else {
			System.out.println("dublicate entry");
		}
	}

	// private static void checkPM() {
	// System.out.println(new ProjectServices().getProjectById(2));
	// }

}
