package com.example.demo.student;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	public StudentRepository repository;
	
	@RequestMapping(path = "/students/create")
	public String create()
	{
		Student student = new Student();
		student.setStdNum(7643);
		student.setName("John Doe");
		student.setCourse("MBCHB");
		repository.save(student);

		student.setStdNum(9310);
		student.setName("James Gbenro");
		student.setCourse("BSc Maths");
		repository.save(student);

		student.setStdNum(2332);
		student.setName("Lorem Ipsum");
		student.setCourse("Dolot Sit");
		repository.save(student);
		
		return "redirect:/students";
	}
	
	@RequestMapping(path = "/students")
	public Iterable<Student> index(){
		return repository.findAll();
	}
	
	@RequestMapping("/students/{id}")
	public Optional<Student> show(@PathVariable("id") Integer id){
		return repository.findById(id);
	}
	
}
