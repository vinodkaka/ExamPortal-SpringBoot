package com.ExamportalSpringboot.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ExamportalSpringboot.Model.Question;

public interface QuestionService {

	public void addQuestion(Question question);
	public List<Question> fetchAllQuestions();
	public Optional <Question> fetchQuestionById(int id) ;
	public void deletebyId(int id) ;
	public void updateExam(int id,Question question);
	
	public List<Question> getQuestionsByExamId(int id);
	
	public String getCorrectAnswerById(Integer questionId);
	
//	public int calculateScore(Map<String, String> allAnswers);
	public int calculateScore(Map<Integer, String> allAnswers);
	
	List<Question> getquestionbyname(String examName);
}
