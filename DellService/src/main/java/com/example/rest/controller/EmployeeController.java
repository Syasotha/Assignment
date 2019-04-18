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

import com.example.rest.model.AddEmployee;
import com.example.rest.model.Employee;
import com.example.rest.services.EmployeeServices;
import com.example.rest.util.MyBatisUtil;


@Path("/employee")
public class EmployeeController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAllEmployee")
	public Response getAllEmployee() {
		List<Employee> employee = new EmployeeServices().getAllEmployee();
		String eString = MyBatisUtil.toJsonFormat(employee);
		return Response.status(200).entity(eString.toString()).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getEmployee/{employeeId}")
	public Response getEmployeeById(@PathParam("employeeId") Integer employeeId) {
		Employee employee = new Employee();
		employee = new EmployeeServices().getEmployeeById(employeeId);
		String eString = MyBatisUtil.toJsonFormat(employee);
		return Response.ok(200).entity(eString.toString()).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addEmployee")
	public Response addEmployee(AddEmployee addEmployee) {
		new EmployeeServices().addEmployee(addEmployee);
		return Response.status(200).entity("Sucessfully saved the Details" + addEmployee.toString()).build();

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateEmployee/{employeeId}")
	public Response updateEmployee(AddEmployee addEmployee) {
		new EmployeeServices().updateEmployee(addEmployee);
		return Response.status(200).entity("Sucessfully Updated the Deails").build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteEmployee/{employeeId}")
	public Response deleteEmployee(@PathParam("employeeId") Integer employeeId) {
		new EmployeeServices().deleteEmployee(employeeId);
		return Response.status(200).entity("Sucessfully Deleted Employee Details").build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAllEmployeeByProjectId/{projectId}")
	public Response getEmployeeByProjectId(@PathParam("projectId") Integer projectId) {
		List<Employee> employee = new EmployeeServices().getEmployeeByProjectId(projectId);
		String eString = MyBatisUtil.toJsonFormat(employee);
		return Response.ok(200).entity(eString.toString()).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAllEmployeeByManagerId/{managerId}")
	public Response getEmployeeByManagerId(@PathParam("managerId") Integer managerId) {
		List<Employee> employee = new EmployeeServices().getEmployeeByManagerId(managerId);
		String eString = MyBatisUtil.toJsonFormat(employee);
		return Response.ok(200).entity(eString.toString()).build();

	}

}
