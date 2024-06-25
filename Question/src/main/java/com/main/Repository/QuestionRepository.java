package com.main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.Entites.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	List<Question> findByQuizId(Long quizId);
	
}
