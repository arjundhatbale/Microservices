package com.main.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	private Logger logger;
	
	@Autowired
	private QuestoinService questoinService; 
	
	public QuestionController(QuestoinService questoinService) {
		this.questoinService = questoinService;
	}
	
	
	@PostMapping("/")
	public ResponseEntity<Question> save(@RequestBody Question question) {
		
		logger.info("Request receive to Save Question...");
		
		return new ResponseEntity<Question>(this.questoinService.add(question),HttpStatus.CREATED);

	}
	
	@GetMapping("/{questionId}")
	public ResponseEntity<Question> getSingleQuestion(@PathVariable Long questionId) {
		logger.info("Request Receive to Get Question By Question Id...");
		Question question = this.questoinService.get(questionId);
		return new ResponseEntity<>(question,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/")
	public  ResponseEntity<List<Question>> getAll(){
		logger.info("Request Receive to Get All Questions...");
		 
		return new ResponseEntity<>(this.questoinService.get(),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{questionId}")
	public ResponseEntity<String> deleteQuestionByid(@PathVariable Long questionId){
		logger.info("Requestion Receive to delete Question  by Question id ...");
		this.questoinService.deleteQuestion(questionId);
		return new ResponseEntity<String>("Question Deleted Successfully...", HttpStatus.OK);
	}

//  get all question of specific quiz
	
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<List<Question>> getQuestionsOfQuiz(@PathVariable Long quizId){
		logger.info("Request Receive to get Question of Quize by quize Id ...");
//		return this.questoinService.getQuestionsOfQuiz(quizId);
		return new ResponseEntity<>(this.questoinService.getQuestionsOfQuiz(quizId),HttpStatus.ACCEPTED);
	}
	
}
