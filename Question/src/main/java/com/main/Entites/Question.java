package com.main.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 
@Entity
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;
	private String question;
	
	private Long quizId;
	
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Question(Long questionId, String question, Long quizId) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.quizId = quizId;
	}


	public Long getQuestionId() {
		return questionId;
	}


	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public Long getQuizId() {
		return quizId;
	}


	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}


	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", quizId=" + quizId + "]";
	}

 
	
	 
}
