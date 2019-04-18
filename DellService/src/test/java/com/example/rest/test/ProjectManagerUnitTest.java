package com.example.rest.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.rest.model.ProjectManager;
import com.example.rest.services.ProjectManagerServices;

public class ProjectManagerUnitTest {
	private static ProjectManagerServices projectManagerServices;

	@BeforeClass
	public static void setUp() {
		projectManagerServices = new ProjectManagerServices();
	}

	@AfterClass
	public static void tearDown() {
		projectManagerServices = null;
	}

	@Test
	public void testGetAllProjectManagers() {
		List<ProjectManager> projectManagers = projectManagerServices.findAll();
		Assert.assertNotNull(projectManagers);
		for (ProjectManager projectManager : projectManagers) {
			System.out.println(projectManager);
		}

	}

	@Test
	public void testGetProjectManagerById() {
		ProjectManager projectManager = projectManagerServices.getProjectManagerById(1);
		Assert.assertNotNull(projectManager);
		System.out.println(projectManager);

	}

	@Test
	public void testInsertProjectManager() {
		ProjectManager projectManager = new ProjectManager();
		projectManager.setId(10);
		projectManager.setName("Hello");
		projectManager.setEmail("test_email@gmail.com");
		projectManager.setContactNumber("0775678936");

		projectManagerServices.insertProjectManager(projectManager);
		Assert.assertTrue(projectManager.getId() != 0);
		ProjectManager createProjectManager = projectManagerServices.getProjectManagerById(projectManager.getId());
		Assert.assertNotNull(createProjectManager);
		Assert.assertEquals(projectManager.getId(), createProjectManager.getId());
		Assert.assertEquals(projectManager.getName(), createProjectManager.getName());
		Assert.assertEquals(projectManager.getEmail(), createProjectManager.getEmail());
		Assert.assertNotEquals(projectManager.getContactNumber(), createProjectManager.getContactNumber());

	}

	@Test
	public void testUpdateProjectManager() {
		long timestamp = System.currentTimeMillis();
		ProjectManager projectManager = projectManagerServices.getProjectManagerById(2);
		projectManager.setName("Anojan" + timestamp);
		projectManager.setContactNumber("0771316568" + timestamp);
		projectManagerServices.updateProjectManager(projectManager);
		ProjectManager updateProjectManager = projectManagerServices.getProjectManagerById(1);
		Assert.assertEquals(projectManager.getName(), updateProjectManager.getName());
		Assert.assertEquals(projectManager.getContactNumber(), updateProjectManager.getContactNumber());

	}

	@Test
	public void testDeleteProjectManager() {
		ProjectManager projectManager = projectManagerServices.getProjectManagerById(3);
		projectManagerServices.deleteProjectManager(projectManager.getId());
		ProjectManager deletedProjectManager = projectManagerServices.getProjectManagerById(3);
		Assert.assertNull(deletedProjectManager);

	}

}
