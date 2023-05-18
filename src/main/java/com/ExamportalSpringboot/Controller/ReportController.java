package com.ExamportalSpringboot.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ExamportalSpringboot.Model.Report;
import com.ExamportalSpringboot.Service.ReportService;
import com.springboot.Exception.DataNotFoundException;

@RestController
@CrossOrigin(origins = "*")
public class ReportController {

	@Autowired
	ReportService reportservice;
	
	@PostMapping("/AddReport")
	public void addReport(@Valid @RequestBody Report report) {
		reportservice.addReport(report);
	}
	
	@GetMapping("/GetReports")
	public List<Report> getAllReports(){
		List<Report> reports=reportservice.fetchAllReports();
		return reports;
	}
	
	@GetMapping("/GetReportById/{id}")
	public ResponseEntity<Report> getReportById(@PathVariable("id")int id ){
		Optional<Report> reports=reportservice.fetchReportById(id);
		if(reports.isPresent())
			return ResponseEntity.ok(reports.get());
			throw new DataNotFoundException("InvalidReportId");
	}
}
