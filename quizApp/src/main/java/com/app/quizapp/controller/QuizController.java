package com.app.quizapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.quizapp.entity.QuestionWrapper;
import com.app.quizapp.entity.Quiz;
import com.app.quizapp.entity.Response;
import com.app.quizapp.service.QuizService;
@CrossOrigin(origins= "http://localhost:5173")
@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	public QuizService quizService;
	@GetMapping("get")
	public ResponseEntity<List<Quiz>> getAllQuizzez(){
		return quizService.getQuizList();
	}
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam Integer numQ,@RequestParam String title){
		return quizService.createQuiz(category,numQ,title);	
	}
	@GetMapping("getQuestions/{id}")
	public ResponseEntity<List<QuestionWrapper>> getAllQuestions(@PathVariable Integer id){
		return quizService.getQuizQuestions(id);
	}
	@GetMapping("get/{id}")
	public ResponseEntity<Optional<Quiz>> getQuizTitleById(@PathVariable Integer id){
		return quizService.getQuizTitleById(id);
	}
	@PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
