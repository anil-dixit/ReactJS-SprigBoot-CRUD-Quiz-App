package com.app.quizapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.quizapp.entity.Question;
import com.app.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	public QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<Iterable<Question>> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@GetMapping("allQuestion")
	public String getAllQuestion(){
		return "testing";
	}
	
	@GetMapping("allQuestions/{category}")
	public ResponseEntity<List<Question>>  getALlQuestionByCategory(@PathVariable String category){
		return questionService. getALlQuestionByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question){
		return questionService.addQuestion(question);	
	}
}
