package com.ExamportalSpringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamportalSpringboot.Model.Exam;

public interface ExamRepository extends JpaRepository<Exam,Integer>{

}
