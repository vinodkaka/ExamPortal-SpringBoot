package com.ExamportalSpringboot.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Exam {

	@Id
	int examId;
	
	@NotEmpty
	@Column(unique=true)
	String examName;
	@NotEmpty
	@Column
	String examDuration;
	@NotEmpty
	@Column
	String examDate;
	@NotNull
	@Column
	String examPercentage;
	
	
	public Exam() {
		super();
	}
	
	
	public Exam(int examId, String examName, String examDuration, String examDate, String examPercentage) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.examDuration = examDuration;
		this.examDate = examDate;
		this.examPercentage = examPercentage;
	}


	public int getExamId() {
		return examId;
	}


	public void setExamId(int examId) {
		this.examId = examId;
	}


	public String getExamName() {
		return examName;
	}


	public void setExamName(String examName) {
		this.examName = examName;
	}


	public String getExamDuration() {
		return examDuration;
	}


	public void setExamDuration(String examDuration) {
		this.examDuration = examDuration;
	}


	public String getExamDate() {
		return examDate;
	}


	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}


	public String getExamPercentage() {
		return examPercentage;
	}


	public void setExamPercentage(String examPercentage) {
		this.examPercentage = examPercentage;
	}


	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", examName=" + examName + ", examDuration=" + examDuration + ", examDate="
				+ examDate + ", examPercentage=" + examPercentage + "]";
	}

	
	
}
