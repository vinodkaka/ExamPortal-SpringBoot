package com.ExamportalSpringboot.Service;

import java.util.List;
import java.util.Optional;

import com.ExamportalSpringboot.Model.Exam;



public interface ExamService {

	public void addExam(Exam exam);
	public List<Exam> fetchAllExams();
	public Optional <Exam> fetchExamById(int id) ;
	public void deletebyId(int id) ;
	public void updateExam(int id, Exam exam);
	
	
}
