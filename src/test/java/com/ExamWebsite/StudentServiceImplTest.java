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

import com.ExamportalSpringboot.Model.Student;
import com.ExamportalSpringboot.Repository.StudentRepository;
import com.ExamportalSpringboot.Service.StudentServiceImpl;

@ExtendWith(SpringExtension.class)
class StudentServiceImplTest {

	@Mock
	StudentRepository studentrepo;
	
	@InjectMocks
	StudentServiceImpl studentservice;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	Student student;
	Student student1;
	List<Student> studentList;
	
	@BeforeAll
	public void setup() {
		student = new Student(1,"vinod","vinod@123","vinod","spring");
		studentList=Arrays.asList(student);
	}
	
	@Test
	public void addstudent() {
		studentrepo.save(student);
		
	}
	
	@Test
	public void getallStudents() {
		when(studentrepo.findAll()).thenReturn(studentList);
		List<Student> students=studentservice.fetchAllStudents();
		assertEquals(studentList,students);
	}
	
	@Test
	public void getstudentbyid() {
		when(studentrepo.findById(1)).thenReturn(Optional.of(student));
		assertThat(studentservice.fetchStudentId(1).get()).isEqualTo(student);
	}
}
