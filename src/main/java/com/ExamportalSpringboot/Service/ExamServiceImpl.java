package com.ExamportalSpringboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamportalSpringboot.Model.Exam;
import com.ExamportalSpringboot.Repository.ExamRepository;

@Service
public class ExamServiceImpl implements ExamService {
	
	@Autowired
	ExamRepository examrepo;

	@Override
	public void addExam(Exam exam) {
		examrepo.save(exam);
	}

	@Override
	public List<Exam> fetchAllExams() {
		List<Exam> exams=examrepo.findAll();
		return exams;
	}

	@Override
	public Optional<Exam> fetchExamById(int id) {
		
		return examrepo.findById(id);
	}

	@Override
	public void deletebyId(int id) {
		examrepo.deleteById(id);
	}

	@Override
	public void updateExam(int id, Exam exam) {
		Exam exams =examrepo.findById(id).orElse(null);
		 exams.setExamId(exam.getExamId());
		 exams.setExamName(exam.getExamName());
		 exams.setExamDuration(exam.getExamDuration());
		 exams.setExamDate(exam.getExamDate());
		 exams.setExamPercentage(exam.getExamPercentage());
		 examrepo.save(exams);
		 }

}
