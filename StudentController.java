package com.example.MultigenesysSoftwareCrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MultigenesysSoftwareCrud.Entity.Student;
import com.example.MultigenesysSoftwareCrud.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping("/save")
	public String save(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	@GetMapping("/getbyId/{Id}")
	public Student getStudentbyId(@PathVariable Long Id) {
		return studentService.getStudentbyId(Id);
	}
	
	@GetMapping("/list")
	public List<Student> findAll() {
		return studentService.findAll();
	}
	
	@PutMapping("/update/{Id}")
	public String update(@RequestBody Student student,@PathVariable Long Id) {
		return studentService.update(student, Id);
	}
	
	@DeleteMapping("/delete/{Id}")
	public String delete(@PathVariable Long Id) {
		return studentService.delete(Id);
	}
}
