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

import com.example.MultigenesysSoftwareCrud.Entity.Course;
import com.example.MultigenesysSoftwareCrud.Service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@PostMapping("/insert")
	public String save(@RequestBody Course course) {
		return courseService.save(course);
	}
	
	@GetMapping("/list")
	public List<Course> list() {
		return courseService.list();
	}
	
	@PutMapping("/update/{Id}")
	public String update(@RequestBody Course course,@PathVariable Long Id) {
		return courseService.update(course, Id);
	}
	
	@DeleteMapping("/delete/{Id}")
	public String delete(@PathVariable Long Id) {
		return courseService.delete(Id);
	}
}
