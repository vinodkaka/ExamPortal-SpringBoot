package com.ExamportalSpringboot.Service;

import java.util.List;
import java.util.Optional;

import com.ExamportalSpringboot.Model.Exam;
import com.ExamportalSpringboot.Model.Student;

public interface StudentService {
	
	public void addStudent(Student student);
	public List<Student> fetchAllStudents();
	public Optional <Student> fetchStudentId(int id) ;
	public void deletebyId(int id) ;
	public void updateStudent(int id, Student student);

}
