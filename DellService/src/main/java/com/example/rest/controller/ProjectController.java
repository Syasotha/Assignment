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

import com.example.rest.model.AddProject;
import com.example.rest.model.Project;
import com.example.rest.services.ProjectServices;
import com.example.rest.util.MyBatisUtil;

@Path("/project")
public class ProjectController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAllProjects")
	public Response getAllProject() {
		List<Project> project = new ProjectServices().getAllProject();
		String pString = MyBatisUtil.toJsonFormat(project);
		return Response.status(200).entity(pString.toString()).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getProject/{projectId}")
	public Response getProjectById(@PathParam("projectId") Integer projectId) {
		Project project = new Project();
		project = new ProjectServices().getProjectById(projectId);
		String pString = MyBatisUtil.toJsonFormat(project);
		return Response.ok(200).entity(pString.toString()).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addProject")
	public Response addProject(AddProject addProject) {

		new ProjectServices().addProjects(addProject);
		return Response.status(200).entity("Sucessfully saved the Details" + addProject.toString()).build();

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateProject/{projectId}")
	public Response updateProject(AddProject addProject) {
		new ProjectServices().updateProject(addProject);
		return Response.status(200).entity("Sucessfully Updated the Deails").build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteProject/{projectId}")
	public Response deleteProject(@PathParam("projectId") Integer projectId) {
		new ProjectServices().deleteProject(projectId);
		return Response.status(200).entity("Sucessfully Deleted Project Details").build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAllProjectByManagerId/{managerId}")
	public Response getProjectByManagerId(@PathParam("managerId") Integer managerId) {
		List<Project> project = new ProjectServices().getprojectByManagerId(managerId);
		String pString = MyBatisUtil.toJsonFormat(project);
		return Response.ok(200).entity(pString.toString()).build();

	}

}
