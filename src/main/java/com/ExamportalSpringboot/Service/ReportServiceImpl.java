package com.ExamportalSpringboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamportalSpringboot.Model.Report;
import com.ExamportalSpringboot.Repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	ReportRepository reportrepo;
	
	@Override
	public void addReport(Report report) {
		reportrepo.save(report);
	}

	@Override
	public List<Report> fetchAllReports() {
		List<Report> reports=reportrepo.findAll();
		return reports;
	}

	@Override
	public Optional<Report> fetchReportById(int id) {
		return reportrepo.findById(id);
	}

}
