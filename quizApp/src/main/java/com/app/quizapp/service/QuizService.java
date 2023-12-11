package com.app.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.quizapp.dao.QuestionDao;
import com.app.quizapp.dao.QuizDao;
import com.app.quizapp.entity.Question;
import com.app.quizapp.entity.QuestionWrapper;
import com.app.quizapp.entity.Quiz;
import com.app.quizapp.entity.Response;

@Service
public class QuizService {

	@Autowired
	public QuizDao quizDao;
	
	@Autowired
	public QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
		try {
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quiz.setCategory(category);
		quiz.setNoOfQuestions(numQ);
		quizDao.save(quiz);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Not Created",HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		List<QuestionWrapper> questionForUser= new ArrayList<>();
		try {
		Optional<Quiz> quiz=quizDao.findById(id);
		List<Question> question=quiz.get().getQuestions();
		
		
		for(Question q: question) {
			QuestionWrapper questions= new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionForUser.add(questions);
		}
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionForUser,HttpStatus.BAD_REQUEST);
	}
		
	
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		int right = 0;
		try {
		Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        
        //int i;
        for(Response response : responses){
        	for(int i=0;i<questions.size();i++) {
        		if(response.getId().equals(questions.get(i).getId())) {
        			 if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
        	                right++;
        		}
        			 break;
        	}
        } 
        }return new ResponseEntity<>(right, HttpStatus.OK);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
	return new ResponseEntity<>(right, HttpStatus.OK);
	}

	public ResponseEntity<List<Quiz>> getQuizList() {
		List<Quiz> quizList=quizDao.findAll();

		return new ResponseEntity<>(quizList,HttpStatus.OK);
	}

	public ResponseEntity<Optional<Quiz>> getQuizTitleById(Integer id) {
		Optional<Quiz> quiz =quizDao.findById(id);
		//String title=quiz.getTitle();
		return new ResponseEntity<>(quiz,HttpStatus.OK);
	}	
}
