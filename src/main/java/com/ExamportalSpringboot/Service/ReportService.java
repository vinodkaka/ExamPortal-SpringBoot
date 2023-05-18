package com.ExamportalSpringboot.Service;

import java.util.List;
import java.util.Optional;

import com.ExamportalSpringboot.Model.Exam;
import com.ExamportalSpringboot.Model.Report;

public interface ReportService {
	
	public void addReport(Report report);
	public List<Report> fetchAllReports();
	public Optional <Report> fetchReportById(int id) ;

}
