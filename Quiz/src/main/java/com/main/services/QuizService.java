package com.main.services;

import java.util.List;

import com.main.entites.Quiz;

public interface QuizService {

	
	Quiz add(Quiz quiz);
	
	List<Quiz> get();
	
	Quiz get(Long id);
}
