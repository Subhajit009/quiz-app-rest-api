package com.epam.quiz.service;


import com.epam.quiz.database.QuestionDatabase;
import com.epam.quiz.database.QuizDatabase;
import com.epam.quiz.exception.QuestionNotFoundException;
import com.epam.quiz.exception.QuizNotFoundException;
import com.epam.quiz.repositories.QuestionRepo;
import com.epam.quiz.repositories.QuizRepo;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service

public class QuizLibrary
{

	@Autowired
	QuizRepo quizRepo;
	@Autowired
	QuestionRepo questionRepo;
	
	QuestionDatabase questionDatabase=new QuestionDatabase();
	
	
    private static Logger logger = LogManager.getLogger(QuizLibrary.class);
    
    
    
    public List<QuizDatabase> getAllQuizes(){
    	List<QuizDatabase> questions=(List<QuizDatabase>) quizRepo.findAll();
    	return questions;

    }
    
    
    public QuizDatabase addQuestion(int questNo,int marks)
    {    
    	QuizDatabase quizDatabase=new QuizDatabase();
    	try {
			
    		Optional<QuestionDatabase> questions=questionRepo.findById(questNo);

    		QuestionDatabase q = questions.get();
    		quizDatabase.setQuest(q.getQuest());
    		quizDatabase.setA(q.getA());
    		quizDatabase.setB(q.getB());
    		quizDatabase.setC(q.getC());
    		quizDatabase.setD(q.getD());
    		quizDatabase.setAnsWer(q.getAnsWer());
    		quizDatabase.setMarks(marks);
    		
		} catch (Exception e) {
			throw new QuestionNotFoundException("Question number to be added not found");
		}
    	
    	return quizRepo.save(quizDatabase);
    }

    public void remove(int questNo)
    {
    	try {
    		quizRepo.deleteById(questNo);
		} catch (Exception e) {
			throw new QuizNotFoundException("Quiz number to be deleted not found ");
			
		}
    }
    
    public boolean updateQuiz(int quizNo,int questNo,int marks)
    {
    	
    	boolean flag = false;
    	if(!questionRepo.existsById(questNo))
    	{
    		throw new QuestionNotFoundException("Question number not found");
    	}
    	if(!quizRepo.existsById(quizNo))
    	{
    		throw new QuizNotFoundException("Quiz number to be updated not found");

    	}
    	else {
    	QuestionDatabase q=questionRepo.findById(questNo).get();
    	QuizDatabase quizDatabase=quizRepo.findById(quizNo).get();
        
    	if(quizDatabase==null)
            logger.info("Empty list!!");
    		
    	
        else{
       
        	
        	quizDatabase.setQuest(q.getQuest());
        	quizDatabase.setA(q.getA());
        	quizDatabase.setB(q.getB());
        	quizDatabase.setC(q.getC());
        	quizDatabase.setD(q.getD());
        	quizDatabase.setAnsWer(q.getAnsWer());
        	quizDatabase.setMarks(marks);
        	quizRepo.save(quizDatabase);
        	flag= true;

        }
    	}
    	return flag;
    } 

}


