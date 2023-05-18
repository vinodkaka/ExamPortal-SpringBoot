package com.ExamportalSpringboot.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ExamportalSpringboot.Model.Exam;
import com.ExamportalSpringboot.Model.Question;
import com.ExamportalSpringboot.Repository.ExamRepository;
import com.ExamportalSpringboot.Repository.QuestionRepository;


@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionRepository questionrepo;
	
	@Autowired
	ExamRepository examrepo;
	
	@Override
	public void addQuestion(Question question) {
//		Optional<Exam> exam=examrepo.findById(id);
//		question.setExam(exam);
		questionrepo.save(question);
	}

	@Override
	public List<Question> fetchAllQuestions() {
		List<Question> questions=questionrepo.findAll();
		return questions;
	}

	@Override
	public Optional<Question> fetchQuestionById(int id) {
		return questionrepo.findById(id);
	}

	@Override
	public void deletebyId(int id) {
		questionrepo.deleteById(id);
	}

	@Override
	public void updateExam(int id, Question question) {
		Question questions=questionrepo.findById(id).orElse(null);
		questions.setQuestionId(questions.getQuestionId());
		questions.setQuestion(question.getQuestion());
		questions.setOption1(question.getOption1());
		questions.setOption2(question.getOption2());
		questions.setOption3(question.getOption3());
		questions.setOption4(question.getOption4());
		questions.setCorrectAnswer(question.getCorrectAnswer());
		questions.setMarks(question.getMarks());
		questions.setExam(question.getExam());
		questionrepo.save(questions);
		
	}
	
	@Override
	public List<Question> getQuestionsByExamId(int id) {
	    return questionrepo.findQuestionsByExamId(id);
	  }
	
	@Override
	public String getCorrectAnswerById(Integer questionId) {
        Question question = questionrepo.findByQuestionId(questionId);
        if (question != null) {
            return question.getCorrectAnswer();
        }
        return null;
    }

//	@Override
//	public int calculateScore(Map<String, String> allAnswers) {
//        int numCorrect = 0;
//        for (Map.Entry<String, String> entry : allAnswers.entrySet()) {
//            String s = entry.getKey();
//            if (!s.startsWith("answers")) {
//                continue;
//            }
//            int ind = s.indexOf("[");
//            Integer questionId = Integer.parseInt(s.substring(ind+1, ind+2));
//            String userAnswer = entry.getValue();
//            String correctAnswer = getCorrectAnswerById(questionId);
//            if (correctAnswer != null && userAnswer.equalsIgnoreCase(correctAnswer)) {
//                numCorrect++;
//            }
//        }
//        return numCorrect;
//    }
	
	
	@Override
	public int calculateScore(Map<Integer, String> allAnswers) {
        int numCorrect = 0;
        for (Map.Entry<Integer,String> entry : allAnswers.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
             String userAnswer = entry.getValue();
             String correctAnswer = getCorrectAnswerById(entry.getKey());
             	if (correctAnswer != null && userAnswer.equalsIgnoreCase(correctAnswer)) {	
               numCorrect++;
          }
                  	
        }
        return numCorrect;
        
        }
	
	@Override
	public List<Question> getquestionbyname(String examName) {
		
		return questionrepo.findQuestionByExamName(examName);
	}

	
}
