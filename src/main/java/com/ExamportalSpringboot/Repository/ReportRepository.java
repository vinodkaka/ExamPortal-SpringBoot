package com.ExamportalSpringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamportalSpringboot.Model.Report;

public interface ReportRepository extends JpaRepository<Report,Integer> {

}
