package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entites.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
