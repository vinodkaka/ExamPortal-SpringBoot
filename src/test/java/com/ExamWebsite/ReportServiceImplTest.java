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

import com.ExamportalSpringboot.Model.Report;
import com.ExamportalSpringboot.Repository.ReportRepository;
import com.ExamportalSpringboot.Service.ReportService;
import com.ExamportalSpringboot.Service.ReportServiceImpl;

@ExtendWith(SpringExtension.class)
class ReportServiceImplTest {

	@Mock
	ReportRepository reportrepo;
	
	@InjectMocks
	ReportServiceImpl reportservice;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	Report report;
	Report report1;
	List<Report> reportList;
	
	@BeforeAll
	public void setup() {
		report =new Report(1,"vinod","12/03/2022",30,null,null);
		reportList=Arrays.asList(report);
	}
	@Test
	public void addReport() {
		reportrepo.save(report);
	}

	@Test
	public void getreportbyid() {
		when(reportrepo.findById(1)).thenReturn(Optional.of(report));
		assertThat(reportservice.fetchReportById(1).get()).isEqualTo(report);
	}
	
	@Test
	public void getallreports() {
		when(reportrepo.findAll()).thenReturn(reportList);
		List<Report> reports=reportservice.fetchAllReports();
		assertEquals(reportList,reports);	
	}
}
