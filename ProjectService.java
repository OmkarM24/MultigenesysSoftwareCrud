package com.example.MultigenesysSoftwareCrud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MultigenesysSoftwareCrud.Dao.ProjectDao;
import com.example.MultigenesysSoftwareCrud.Entity.Project;

@Service
public class ProjectService {
	
	@Autowired
	ProjectDao projectDao;
	
	public String save(Project project) {
		return projectDao.save(project);
	}

	public List<Project> list() {
		return projectDao.list();
	}
	
	public String update(Project project,Long Id) {
		return projectDao.update(project, Id);
	}
	
	public String delete(Long Id) {
		return projectDao.delete(Id);
	}
}
