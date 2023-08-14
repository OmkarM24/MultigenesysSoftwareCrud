package com.example.MultigenesysSoftwareCrud.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.MultigenesysSoftwareCrud.Entity.Course;

@Repository
public class CourseDao {
	
	@Autowired
	SessionFactory sf;
	
	public String save(Course course) {
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(transaction);
		transaction.commit();
		session.close();
		return "Data Inserted..!!";
	}
	
	public List<Course> list() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Course.class);
		List<Course> l =criteria.list();
		session.close();
		return l;
	}
	
	public String update(Course course,Long Id) {
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		Course crs=null;
		crs = session.get(Course.class, Id);
		if(crs != null) {
			crs.setCourseTitle(course.getCourseTitle());
			crs.setCoursestartDate(course.getCoursestartDate());
			crs.setCourseendDate(course.getCourseendDate());
		}
		else if(crs == null) {
			return "Course not found :"+Id;
		}
		transaction.commit();
		session.close();
		return "Data Updated..!!";	
	}
	
	public String delete(Long Id) {
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		Course course = session.get(Course.class, Id);
		session.delete(course);
		transaction.commit();
		session.close();
		return "Data Deleted..!!";
	}	
}
