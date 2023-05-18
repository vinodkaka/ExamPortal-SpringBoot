package com.ExamportalSpringboot.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ExamportalSpringboot.Model.Question;
import com.ExamportalSpringboot.Model.Student;
import com.ExamportalSpringboot.Service.StudentService;
import com.springboot.Exception.DataNotFoundException;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	StudentService studentservice;
	
	@PostMapping("/AddStudent")
	public void AddStudent(@Valid @RequestBody Student student) {
		studentservice.addStudent(student);
	}
	
	@GetMapping("/GetStudents")
	public List<Student> getAllStudents(){
		List<Student> students=studentservice.fetchAllStudents();
		return students;
	}
	
	@GetMapping("/GetStudentById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
		Optional<Student> students=studentservice.fetchStudentId(id);
		
		if(students.isPresent())
			return ResponseEntity.ok(students.get());
			throw new DataNotFoundException("Invalid ExamId");
	}
	
	@DeleteMapping("/DeleteStudentById/{id}")
	public void deleteStudentById(@PathVariable("id") int id) {
		studentservice.deletebyId(id);
	}
	
	@PutMapping(value = "/UpdateStudentById/{id}")
	public void UpdateQquestion(@PathVariable("id") int id,@Valid  @RequestBody Student student) {
		studentservice.updateStudent(id, student);

	}
}
