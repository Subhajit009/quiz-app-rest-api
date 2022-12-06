package com.epam.quiz.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.quiz.database.QuestionDatabase;
import com.epam.quiz.dto.QuestionDto;
import com.epam.quiz.service.QuestionLibrary;

@RestController
public class QuestionRestController {
	
	@Autowired
	QuestionLibrary questionLibrary;
	
	@GetMapping("questions")
	public  ResponseEntity<List<QuestionDatabase>> getQuestions() {
		
		return new ResponseEntity<>(questionLibrary.getAllQuestions(),HttpStatus.OK);
	}

	@PostMapping("questions")
	public ResponseEntity<String> insert(@RequestBody @Valid QuestionDto questionDto ) {
		String[]options=new String[4];
		options[0]=questionDto.getA();
		options[1]=questionDto.getB();
		options[2]=questionDto.getC();
		options[3]=questionDto.getD();
		questionLibrary.createQuestion(questionDto.getQuest(), options,questionDto.getAnsWer());
		return new ResponseEntity<>("Question added!!",HttpStatus.CREATED);
	}
	
	@PutMapping("questions/{questioId}")
	public ResponseEntity<Void> edit(@PathVariable(value="questioId") int qn,@RequestBody QuestionDto questionDto ) {
		String[] options=new String[4];
		options[0]=questionDto.getA();
		options[1]=questionDto.getB();
		options[2]=questionDto.getC();
		options[3]=questionDto.getD();
		questionLibrary.updateQuestion(qn,questionDto.getQuest(), options,questionDto.getAnsWer());
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("questions/{questioId}")
	public ResponseEntity<Void> deletebyId(@PathVariable(value = "questioId") int qn) {
		 questionLibrary.remove(qn);
		 return ResponseEntity.noContent().build();
	}
}
