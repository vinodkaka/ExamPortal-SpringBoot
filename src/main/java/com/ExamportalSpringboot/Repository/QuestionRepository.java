package com.ExamportalSpringboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ExamportalSpringboot.Model.Question;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
	
	@Query(value = "SELECT * FROM Question q WHERE q.exam_exam_id= :id", nativeQuery = true)
	List<Question> findQuestionsByExamId(@Param("id") int id);
	

	
	//List<Question> findQuestionsByExamId(int exam_examid);
	Question findByQuestionId(Integer questionId);
	
	

	
	
	@Query(value ="select * from Question q where q.exam_exam_id = (select exam_id from exam e where e.exam_name= :examName)" ,nativeQuery = true)
	List<Question> findQuestionByExamName(@Param("examName") String examName);
}
