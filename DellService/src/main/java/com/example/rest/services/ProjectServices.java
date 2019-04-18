package com.example.rest.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.rest.mapper.ProjectMapper;
import com.example.rest.model.AddProject;
import com.example.rest.model.Project;
import com.example.rest.util.MyBatisUtil;

public class ProjectServices implements ProjectMapper {

	@Override
	public List<Project> getAllProject() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProjectMapper mapper = session.getMapper(ProjectMapper.class);
			return mapper.getAllProject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void updateProject(AddProject addProject) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
			projectMapper.updateProject(addProject);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public void deleteProject(Integer projectId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
			projectMapper.deleteProject(projectId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public Project getProjectById(Integer projectId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
			return projectMapper.getProjectById(projectId);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void addProjects(AddProject addProject) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
			projectMapper.addProjects(addProject);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public List<Project> getprojectByManagerId(Integer managerId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
			return projectMapper.getprojectByManagerId(managerId);
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public AddProject getProject(AddProject addProject) {
		AddProject addProject1 = new AddProject();
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProjectMapper projectMapper = session.getMapper(ProjectMapper.class);
			addProject1 = projectMapper.getProject(addProject1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addProject1;
	}

}
