package com.example.MultigenesysSoftwareCrud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MultigenesysSoftwareCrud.Dao.CourseDao;
import com.example.MultigenesysSoftwareCrud.Entity.Course;

@Service
public class CourseService {

	@Autowired
	CourseDao courseDao;
	
	public String save(Course course) {
		return courseDao.save(course);
	}
	
	public List<Course> list() {
		return courseDao.list();
	}
	
	public String update(Course course,Long Id) {
		return courseDao.update(course, Id);
	}
	
	public String delete(Long Id) {
		return courseDao.delete(Id);
	}
}
