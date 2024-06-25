package com.main.Service;

import java.util.List;

import com.main.Entites.Question;

public interface QuestoinService {

	
	Question add(Question question);
	
	List<Question> get();
	
	Question get(Long questionId);
	
	String deleteQuestion(Long questionId);
	List<Question> getQuestionsOfQuiz(Long questionId);
	
}
