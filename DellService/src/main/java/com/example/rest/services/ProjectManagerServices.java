package com.example.rest.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.rest.mapper.ProjectManagerMapper;
import com.example.rest.model.ProjectManager;
import com.example.rest.util.MyBatisUtil;

public class ProjectManagerServices implements ProjectManagerMapper {

	@Override
	public List<ProjectManager> findAll() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProjectManagerMapper mapper = session.getMapper(ProjectManagerMapper.class);
			return mapper.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void insertProjectManager(ProjectManager projectManager) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProjectManagerMapper projectManagerMapper = sqlSession.getMapper(ProjectManagerMapper.class);
			projectManagerMapper.insertProjectManager(projectManager);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public void updateProjectManager(ProjectManager projectManager) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProjectManagerMapper projectManagerMapper = sqlSession.getMapper(ProjectManagerMapper.class);
			projectManagerMapper.updateProjectManager(projectManager);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void deleteProjectManager(Integer projectManagerId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProjectManagerMapper projectManagerMapper = sqlSession.getMapper(ProjectManagerMapper.class);
			projectManagerMapper.deleteProjectManager(projectManagerId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public ProjectManager getProjectManagerById(Integer projectManagerId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProjectManagerMapper projectManagerMapper = sqlSession.getMapper(ProjectManagerMapper.class);
			return projectManagerMapper.getProjectManagerById(projectManagerId);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public boolean editProjectManager(ProjectManager projectManager, Integer projectManagerId) {
		// boolean success=false;

		return false;
	}

	@Override
	public ProjectManager getProjectManager(ProjectManager projectManager) {
		ProjectManager manager = new ProjectManager();
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProjectManagerMapper managerMapper = session.getMapper(ProjectManagerMapper.class);
			manager = managerMapper.getProjectManager(projectManager);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manager;
	}

	// @Override
	// public boolean deleteProjectManagerById(Integer projectManagerId) {
	// SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	// try {
	//
	// ProjectManagerMapper projectManagerMapper =
	// sqlSession.getMapper(ProjectManagerMapper.class);
	// projectManagerMapper.deleteProjectManager(projectManagerId);
	// sqlSession.commit();
	// } finally {
	// sqlSession.close();
	// }
	//
	// }

}
