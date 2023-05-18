package com.ExamportalSpringboot.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
public class Report {

	@Id
	int reportId;
	@NotEmpty
	@Column
	String studentName;
	@Column
	@NotNull
	String examDate;
	@NotNull
	@Column
	int score;
	
	@OneToOne
	private Student student;
	
	@OneToOne
	private Exam exam;

	
	
	public Report() {
		super();
	}



	public Report(int reportId, String studentName, String examDate, int score, Student student, Exam exam) {
		super();
		this.reportId = reportId;
		this.studentName = studentName;
		this.examDate = examDate;
		this.score = score;
		//this.student = student;
		this.exam = exam;
	}



	public int getReportId() {
		return reportId;
	}



	public void setReportId(int reportId) {
		this.reportId = reportId;
	}



	public String getStudentName() {
		return studentName;
	}



	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}



	public String getExamDate() {
		return examDate;
	}



	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}



	public float getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public Exam getExam() {
		return exam;
	}



	public void setExam(Exam exam) {
		this.exam = exam;
	}



	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", studentName=" + studentName + ", examDate=" + examDate + ", score="
				+ score + ", student=" + student + ", exam=" + exam + "]";
	}
	
	
	
}
