package com.epam.quiz.service;



import com.epam.quiz.database.QuestionDatabase;
import com.epam.quiz.exception.QuestionNotFoundException;
import com.epam.quiz.repositories.QuestionRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class QuestionLibrary {
	

	@Autowired
	QuestionRepo questionRepo;
	
    

    
    
    public List<QuestionDatabase> getAllQuestions(){
    	List<QuestionDatabase> questions=(List<QuestionDatabase>) questionRepo.findAll();
    	return questions;
    }
    
    public QuestionDatabase getQuestionById(int id){
    	Optional<QuestionDatabase> question = questionRepo.findById(id);
    	if(!question.isPresent())
    		return null;
    	return question.get();
    }
    
    public  QuestionDatabase createQuestion(String quest,String[] ans,char a)
    {

    QuestionDatabase questionDatabase=new QuestionDatabase();

    	questionDatabase.setQuest(quest);
    	questionDatabase.setA(ans[0]);
    	questionDatabase.setB(ans[1]);
    	questionDatabase.setC(ans[2]);
    	questionDatabase.setD(ans[3]);        	
    	questionDatabase.setAnsWer(a);
    	return questionRepo.save(questionDatabase);
    }
	
    public void remove(int questNo)
    {
    		if(questionRepo.existsById(questNo)) {
    			questionRepo.deleteById(questNo);
    		}
    		else {
    			throw new QuestionNotFoundException("Question not found");
				
			}

              
    }

    public void updateQuestion(int qn,String quest,String[] ans,char a) {
    	
    	try {
			
    		Optional<QuestionDatabase> questions=questionRepo.findById(qn);
     	
    		QuestionDatabase q = questions.get();
    		q.setQuest(quest);
    		q.setA(ans[0]);
    		q.setB(ans[1]);
    		q.setC(ans[2]);
    		q.setD(ans[3]);
    		q.setAnsWer(a);
    		questionRepo.save(q);
		} catch (Exception e) {
			throw new QuestionNotFoundException("Question to be updated not found");
		}
        }


}
