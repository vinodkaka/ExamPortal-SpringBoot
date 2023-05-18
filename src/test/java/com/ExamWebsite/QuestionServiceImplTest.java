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
import com.ExamportalSpringboot.Model.Question;
import com.ExamportalSpringboot.Repository.QuestionRepository;
import com.ExamportalSpringboot.Service.QuestionServiceImpl;

@ExtendWith(SpringExtension.class)
class QuestionServiceImplTest {

@Mock	
QuestionRepository questionrepo;

@InjectMocks
QuestionServiceImpl questionservice;

Question question;
Question question1;
List<Question> questionList;

@BeforeAll
public void setup() {
	question=new Question(1,"java","programing","robust","multithreaded","programing","correctanswer",25, null);
	questionList=Arrays.asList(question);
}

@Test
public void addquestion() {
	questionrepo.save(question);
}

@Test
public void getallquestions() {
	when(questionrepo.findAll()).thenReturn(questionList);
	List<Question> questions=questionservice.fetchAllQuestions();
	assertEquals(questionList,questions);
}

public void fetchquestionbyid() {
	when(questionrepo.findById(1)).thenReturn(Optional.of(question));
	assertThat(questionservice.fetchQuestionById(1).get()).isEqualTo(question);

}


}
