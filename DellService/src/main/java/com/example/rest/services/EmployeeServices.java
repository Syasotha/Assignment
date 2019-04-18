package com.example.rest.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.rest.mapper.EmployeeMapper;
import com.example.rest.model.AddEmployee;
import com.example.rest.model.Employee;
import com.example.rest.util.MyBatisUtil;

public class EmployeeServices implements EmployeeMapper {

	@Override
	public List<Employee> getAllEmployee() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			return employeeMapper.getAllEmployee();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			return employeeMapper.getEmployeeById(employeeId);
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public void addEmployee(AddEmployee addEmployee) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			employeeMapper.addEmployee(addEmployee);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public void updateEmployee(AddEmployee addEmployee) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			employeeMapper.updateEmployee(addEmployee);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			employeeMapper.deleteEmployee(employeeId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public List<Employee> getEmployeeByProjectId(Integer projectId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			return employeeMapper.getEmployeeByProjectId(projectId);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public List<Employee> getEmployeeByManagerId(Integer managerId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			return employeeMapper.getEmployeeByManagerId(managerId);
		} finally {
			sqlSession.close();
		}
	}

}
