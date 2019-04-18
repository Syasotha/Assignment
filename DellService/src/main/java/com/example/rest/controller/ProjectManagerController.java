package com.example.rest.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.rest.model.ProjectManager;
import com.example.rest.services.ProjectManagerServices;
import com.example.rest.util.MyBatisUtil;
import com.example.rest.validation.ProjectManagerValidation;

@Path("/manager")
public class ProjectManagerController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAllManagers")
	public Response getAllProjectManagers() {
		List<ProjectManager> pm = new ProjectManagerServices().findAll();
		String pMString = MyBatisUtil.toJsonFormat(pm);
		return Response.status(200).entity(pMString.toString()).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addProjectManager")
	public Response addProjectManager(ProjectManager projectManager) {
		boolean checkAvalibality = ProjectManagerValidation.isProjectManagerAvailable(projectManager);

		if (checkAvalibality) {
			new ProjectManagerServices().insertProjectManager(projectManager);
			return Response.status(200).entity("Sucessfully saved the Details").build();

		} else {
			return Response.status(200).entity(" THis detail is already avilable in Database").build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateProjectManager/{projectManagerId}")
	public Response updateProjectManager(@PathParam("projectManagerId") Integer projectManagerId,
			ProjectManager projectManager) {
		new ProjectManagerServices().updateProjectManager(projectManager);
		return Response.status(200).entity("Sucessfully Updated the Details").build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteProjectManager/{projectManagerId}")
	public Response deleteProjectManager(@PathParam("projectManagerId") Integer projectManagerId) {
		new ProjectManagerServices().deleteProjectManager(projectManagerId);
		return Response.status(200).entity("Sucessfully Deleted ProjectManager Details").build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("getProjectManagerById/{projectManagerId}")
	public Response getProjectManagerById(@PathParam("projectManagerId") Integer projectManagerId) {
		ProjectManager projectManager = new ProjectManager();
		projectManager = new ProjectManagerServices().getProjectManagerById(projectManagerId);
		String pMString = MyBatisUtil.toJsonFormat(projectManager);
		return Response.ok(200).entity(pMString.toString()).build();
	}

	@GET
	@Path("/hi")
	public String getHi() {
		return "HI";

	}

}
