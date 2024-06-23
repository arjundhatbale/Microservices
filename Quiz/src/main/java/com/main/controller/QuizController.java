package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entites.Quiz;
import com.main.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService; 
	
	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}
	
	@PostMapping("/")
	public Quiz add(@RequestBody Quiz quiz) {
		return this.quizService.add(quiz);
	}
	
	@GetMapping("/")
	public List<Quiz> getAll(){
		return this.quizService.get()	;
	}
	
	@GetMapping("/{id}")
	public Quiz get(@PathVariable Long id) {
		Quiz quiz = this.quizService.get(id);
		return quiz;
	}
}
