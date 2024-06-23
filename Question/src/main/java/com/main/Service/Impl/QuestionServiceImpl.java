package com.main.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.Entites.Question;
import com.main.Repository.QuestionRepository;
import com.main.Service.QuestoinService;
import com.main.exception.ResourceNotFoundException;

@Service
public class QuestionServiceImpl implements QuestoinService{

	
	@Autowired
	private QuestionRepository questionRepository; 
	
	public QuestionServiceImpl(QuestionRepository questionRepository) {
		this.questionRepository =  questionRepository;
	}
	
	
	@Override
	public Question add(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(question);
	}

	@Override
	public List<Question> get() {
		// TODO Auto-generated method stub
		return this.questionRepository.findAll();
	}

	@Override
	public Question get(Long questionId) {
		// TODO Auto-generated method stub
		return this.questionRepository.findById(questionId).orElseThrow(()-> new ResourceNotFoundException("Queston is not found with id = " + questionId + " ..."));
	}


	@Override
	public List<Question> getQuestionsOfQuiz(Long questionId) {
		// TODO Auto-generated method stub
		return this.questionRepository.findByQuizId(questionId);
	}

}
