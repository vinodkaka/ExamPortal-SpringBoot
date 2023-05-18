package com.ExamportalSpringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamportalSpringboot.Model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
