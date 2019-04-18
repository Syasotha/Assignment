package com.example.rest.mapper;

import java.util.List;

import com.example.rest.model.AddEmployee;
import com.example.rest.model.Employee;

public interface EmployeeMapper {
	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(Integer employeeId);

	public void addEmployee(AddEmployee addEmployee);

	public void updateEmployee(AddEmployee addEmployee);

	public void deleteEmployee(Integer employeeId);

	public List<Employee> getEmployeeByProjectId(Integer projectId);

	public List<Employee> getEmployeeByManagerId(Integer managerId);

}
