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

import com.example.MultigenesysSoftwareCrud.Entity.Project;
import com.example.MultigenesysSoftwareCrud.Service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@PostMapping("/save")
	public String save(@RequestBody Project project) {
		return projectService.save(project);
	}
	
	@GetMapping("/getAll")
	public List<Project> list() {
		return projectService.list();
	}
	
	@PutMapping("/update/{Id}")
	public String update(@RequestBody Project project,@PathVariable Long Id) {
		return projectService.update(project, Id);
	}
	
	@DeleteMapping("/delete/{Id}")
	public String delete(@PathVariable Long Id) {
		return projectService.delete(Id);
	}
}
