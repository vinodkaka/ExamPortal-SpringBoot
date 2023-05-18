package com.ExamportalSpringboot.Controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ExamportalSpringboot.Model.Exam;
import com.ExamportalSpringboot.Service.ExamService;
import com.springboot.Exception.DataNotFoundException;

@RestController
@CrossOrigin(origins = "*")
public class ExamController {
	
	@Autowired
	ExamService examservice;
	
	@PostMapping(value="/AddExam")
	public void addExam(@Valid @RequestBody Exam exam)
	{
		examservice.addExam(exam);
	}

	@GetMapping("/GetExams")
	public List getAllExams()
	{
		List exams=examservice.fetchAllExams();
		return exams;
	}
	
	@GetMapping("/GetExamById/{id}")
	public ResponseEntity<Object> getExamById(@PathVariable("id") int id)
	{
		Optional exam= examservice.fetchExamById(id);
		if(exam.isPresent())
			 return ResponseEntity.ok(exam.get());
			 throw new DataNotFoundException("Invalid ExamId");
	}
	
	@DeleteMapping("/DeleteExamById/{id}")
	public void deleteExamById(@PathVariable("id") int id) {
		examservice.deletebyId(id);
	}
	
	@PutMapping(value = "/UpdateExamById/{id}")
	public void UpdateExam( @PathVariable("id") int id,@Valid  @RequestBody Exam exam) {
		examservice.updateExam(id, exam);

	}
}
