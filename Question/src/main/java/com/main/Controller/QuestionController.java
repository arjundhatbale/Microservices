package com.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.Entites.Question;
import com.main.Service.QuestoinService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	
	@Autowired
	private QuestoinService questoinService; 
	
	public QuestionController(QuestoinService questoinService) {
		this.questoinService = questoinService;
	}
	
	
	@PostMapping("/")
	public Question save(@RequestBody Question question) {
		return this.questoinService.add(question);
	}
	
	@GetMapping("/{questionId}")
	public Question getSingleQuestion(@PathVariable Long questionId) {
		Question question = this.questoinService.get(questionId);
		return question;
	}
	
	@GetMapping("/")
	public List<Question> getAll(){
		return this.questoinService.get();
	}

//  get all question of specific quiz
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
		return this.questoinService.getQuestionsOfQuiz(quizId);
	}
	
}
