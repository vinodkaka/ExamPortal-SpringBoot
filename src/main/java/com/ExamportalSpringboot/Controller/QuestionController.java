package com.ExamportalSpringboot.Controller;

import java.util.List;
import java.util.Map;
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
import com.ExamportalSpringboot.Service.QuestionService;
import com.springboot.Exception.DataNotFoundException;

@RestController
@CrossOrigin(origins = "*")
public class QuestionController {
	
	@Autowired
	QuestionService questionservice;

	@PostMapping(value="/AddQuestion")
	public void addQuestion( @Valid @RequestBody Question question)
	{
questionservice.addQuestion(question);
	}

	@GetMapping("/GetQuestions")
	public List<Question> getAllQuestions()
	{
		List<Question> questions=questionservice.fetchAllQuestions();
		return questions;
	}
	
	@GetMapping("/GetQuestionById/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable("id") int id)
	{
		Optional<Question> question= questionservice.fetchQuestionById(id);
		if(question.isPresent())
			 return ResponseEntity.ok(question.get());
			 throw new DataNotFoundException("Invalid questionId");
	}
	
	@DeleteMapping("/DeleteQuestionById/{id}")
	public void deleteQuestionById(@PathVariable("id") int id) {
		questionservice.deletebyId(id);
	}
	
	@PutMapping(value = "/UpdateQuestionById/{id}")
	public void UpdateQquestion(@PathVariable("id") int id,@Valid  @RequestBody Question question) {
		questionservice.updateExam(id, question);

	}
	
	@GetMapping(value="/questionbyexamid/{id}")
	public List<Question> getquestionbyexamid(@PathVariable("id") int id) {
		return questionservice.getQuestionsByExamId(id);
	}
	
//	@PostMapping(value="/submitanswer")
//	public void validation(@RequestBody Map<String, String> allAnswers) {
//		int score = questionservice.calculateScore(allAnswers);
//	}
	
	@PostMapping(value="/submitanswer")
	public int validation(@RequestBody Map<Integer, String> allAnswers) {
		return questionservice.calculateScore(allAnswers);

	}
	
	@GetMapping(value="/byexamname/{examName}")
	public List<Question> getquestionbyname(@PathVariable("examName") String examName) {
		return questionservice.getquestionbyname(examName);
	}
	
}
