package com.ExamWebsite;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ExamportalSpringboot.Model.Exam;
import com.ExamportalSpringboot.Repository.ExamRepository;
import com.ExamportalSpringboot.Service.ExamServiceImpl;

@ExtendWith(SpringExtension.class)
class ExamServiceImplTest {

	@Mock
	ExamRepository examrepository;
	
	@InjectMocks
	ExamServiceImpl examservice;
	
	
	Exam exam;
	Exam exam1;
	List<Exam> examslist;
	
	@BeforeAll
	public void setup() {
		exam=new Exam(1,"java","30","23/07/2023","80");
		examslist=Arrays.asList(exam);
				
	}

	@Test
	public void fetchallexams() {
		when(examrepository.findAll()).thenReturn(examslist);
		List<Exam> exams=examservice.fetchAllExams();
		assertEquals(examslist,exams);
	}
	
	@Test
	public void addexam() {
		examrepository.save(exam);
	}
	
	@Test
	public void fetchexambyid() {
		when(examrepository.findById(1)).thenReturn(Optional.of(exam));
		assertThat(examservice.fetchExamById(1).get()).isEqualTo(exam);
	}
	
}
