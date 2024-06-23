package com.main.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.Exception.ResourceNotFoundException;
import com.main.entites.Quiz;
import com.main.repository.QuizRepository;
import com.main.services.QuestionClient;
import com.main.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuestionClient questionClient;
	
	public QuizServiceImpl(QuizRepository quizRepository,QuestionClient questionClient) {
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	
	}
	
	@Override
	public Quiz add(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
	    // Fetch all quizzes
	    List<Quiz> quizzes = this.quizRepository.findAll();

	    // Map each quiz to a new quiz with questions set
	    List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
	        // Set the questions for the quiz
	        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
	        // Return the modified quiz
	        return quiz;
	    }).collect(Collectors.toList());

	    return newQuizList;
	}


	@Override
	public Quiz get(Long id) {
		// TODO Auto-generated method stub
		Quiz quiz =  this.quizRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Quis is not found by the id : "+ id + " . "));
		quiz.setQuestions(questionClient.getQuestionOfQuiz(id));
		return quiz;
	}

}
