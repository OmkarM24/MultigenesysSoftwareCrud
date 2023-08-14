package com.example.MultigenesysSoftwareCrud.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.MultigenesysSoftwareCrud.Entity.Product;
import com.example.MultigenesysSoftwareCrud.Entity.Student;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory sf;

	public String save(Student student) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(student);
		tr.commit();
		session.close();
		return "Student Data Inserted..";
	}
	
	public Student getStudentbyId(Long Id) {
		Session session=sf.openSession();
		Student student=session.get(Student.class, Id);
		session.close();
		return student;
	}
	
	public List<Student> findAll() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Student.class);
		List<Student> l=criteria.list();
		session.close();
		return l;
	}
	
	public String update(Student student,Long Id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Student std=null;
		std=session.get(Student.class, Id);
		if(std != null) {
			std.setsName(student.getsName());
			std.setEmail(student.getEmail());
		}
		else if(std == null) {
			return "Student not found :"+Id;
		}
		session.update(std);
		tr.commit();
		session.close();
		return "Student Data updated";
	}
	
	public String delete(Long Id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Student student =session.get(Student.class, Id);
		session.delete(student);
		tr.commit();
		session.close();
		return "Deleted..";
	}
}
