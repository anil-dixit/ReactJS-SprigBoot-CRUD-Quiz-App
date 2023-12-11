package com.app.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.quizapp.dao.QuestionDao;
import com.app.quizapp.entity.Question;

@Service
public class QuestionService {

	@Autowired
	public QuestionDao questionDao;
	
	public ResponseEntity<Iterable<Question>>getAllQuestions(){
		//Iterable<Question> questionList=questionDao.findAll();
		try {
		return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>( questionDao.findAll(),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Question>> getALlQuestionByCategory(String category){
		try {
		return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<String> addQuestion(Question question){
		try {
			Question ques= new Question();
			ques.setCategory(question.getCategory());
			ques.setDiffiultyLevel(question.getDiffiultyLevel());
			ques.setOption1(question.getOption1());
			ques.setOption2(question.getOption2());
			ques.setOption3(question.getOption3());
			ques.setOption4(question.getOption4());
			ques.setQuestionTitle(question.getQuestionTitle());
			ques.setRightAnswer(question.getRightAnswer());
			questionDao.save(ques);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed ",HttpStatus.BAD_REQUEST);
	}
}
