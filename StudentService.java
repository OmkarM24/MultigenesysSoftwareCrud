package com.example.MultigenesysSoftwareCrud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MultigenesysSoftwareCrud.Dao.StudentDao;
import com.example.MultigenesysSoftwareCrud.Entity.Student;

@Service
public class StudentService {
	@Autowired
	StudentDao studentDao;
	
	
	public String save(Student student) {
		if(student.getEmail().contains("@")) {
		return studentDao.save(student) ;
	}
		return "Student "+student.getEmail()+"not valid";
	}
	
	public Student getStudentbyId(Long Id) {
		return studentDao.getStudentbyId(Id);
	}
	
	public List<Student> findAll() {
		return studentDao.findAll();
	}
	
	public String update(Student student,Long Id) {
		return studentDao.update(student, Id);
	}
	
	public String delete(Long Id) {
		return studentDao.delete(Id);
	}
}
