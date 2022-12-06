package com.epam.quiz.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class MyExceptionHandler {


		
		@ExceptionHandler(value=QuestionNotFoundException.class)
		public ResponseEntity<ExceptionResponse> handleQuestionNotFoundException(QuestionNotFoundException ex,WebRequest req)
		{
			ExceptionResponse exceptionResponse=new ExceptionResponse();
			exceptionResponse.setError(ex.getMessage());
			exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.name());
			exceptionResponse.setTimeStamp(new Date().toString());;
			exceptionResponse.setPath(req.getDescription(false));
			
			return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.BAD_REQUEST);
			
		}
		
		@ExceptionHandler(value=QuizNotFoundException.class)
		public ResponseEntity<ExceptionResponse> handleQuizNotFoundException(QuizNotFoundException ex,WebRequest req)
		{
			ExceptionResponse exceptionResponse=new ExceptionResponse();
			exceptionResponse.setError(ex.getMessage());
			exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.name());
			exceptionResponse.setTimeStamp(new Date().toString());;
			exceptionResponse.setPath(req.getDescription(false));
			
			return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.BAD_REQUEST);
			
		}
		
		@ExceptionHandler(value = MethodArgumentNotValidException.class)
		public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest req) {
			List<String> errors = new ArrayList<>();
			ex.getBindingResult().getAllErrors().forEach(error -> {
				errors.add(error.getDefaultMessage());
			});
			
			ExceptionResponse exRes = new ExceptionResponse();
			exRes.setError(errors.toString());
			exRes.setStatus(HttpStatus.BAD_REQUEST.name());
			exRes.setTimeStamp(new Date().toString());
			exRes.setPath(req.getDescription(false));
			
			return new ResponseEntity<>(exRes, HttpStatus.BAD_REQUEST);
		}

	}

