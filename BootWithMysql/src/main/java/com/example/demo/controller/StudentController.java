package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepo repo;
	
	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		return repo.findAll();
	}
	
	@PostMapping("/student")
	public Student addStudent(Student stud)
	{
		repo.save(stud);
		return stud;
	}
	
	@DeleteMapping("/student/{roll}")
	public String deleteStudent(@PathVariable("roll") int roll)
	{
		repo.deleteById(roll);
		return "Deleted Studnt";
	}
	
	@PutMapping("/student")
	public Student upadateOrAddStudent(Student stud)
	{
		repo.save(stud);
		return stud;
	}
}
