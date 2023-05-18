package com.ExamportalSpringboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamportalSpringboot.Model.Student;
import com.ExamportalSpringboot.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentrepo;

	@Override
	public void addStudent(Student student) {
		studentrepo.save(student);
	}

	@Override
	public List<Student> fetchAllStudents() {
		List<Student> students=studentrepo.findAll();
		return students;
	}

	@Override
	public Optional<Student> fetchStudentId(int id) {
		return studentrepo.findById(id);
	}

	@Override
	public void deletebyId(int id) {
		studentrepo.deleteById(id);
	}

	@Override
	public void updateStudent(int id, Student student) {
		Student students=studentrepo.findById(id).orElse(null);
		students.setStudentId(student.getStudentId());
		students.setStudentName(student.getStudentName());
		students.setStudentEmail(student.getStudentEmail());
		students.setStudentPassword(student.getStudentPassword());
		students.setEnrolExam(student.getEnrolExam());
		studentrepo.save(students);
	}

}
