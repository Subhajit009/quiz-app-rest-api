//package com.epam.quiz.dao;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.stereotype.Repository;
//
//import com.epam.quiz.database.QuestionDatabase;
//
//
//import java.util.*;
////@Component
//@Repository
//public class QuestionDao implements QuestionDaoInterface {
//    private static Logger logger= LogManager.getLogger(QuestionDao.class);
//
//	EntityManagerFactory eManagerFactory = Persistence.createEntityManagerFactory("question-library");
//    EntityManager eManager=eManagerFactory.createEntityManager();
//	
//    public List<QuestionDatabase> findAllQuestions() {
//    	return eManager.createQuery("select q from Question q").getResultList();
//    }
//    
//    
//	 public QuestionDatabase addQuestionToLibrary(QuestionDatabase questionDatabase)
//     {
//     
//     	try {
//     		eManager.getTransaction().begin();
//     		eManager.persist(questionDatabase);
//     		eManager.getTransaction().commit();
//        return questionDatabase;
//     	}catch (Exception e) {
//     		return null;
//		}     	  	
//     }
//
//	 public void deleteQuestionById(QuestionDatabase question) {
//	    	
//
//	    		logger.info(question);
//	    		eManager.getTransaction().begin();
//	    		eManager.remove(question);
//	    		eManager.getTransaction().commit();
//	    	logger.info("Delete Successful");
//	    }
//	 
//	 public void updateQuestionInDatabase(List<QuestionDatabase> questions,int qn,String quest,String[] ans,char a){
//		 QuestionDatabase q=eManager.find(QuestionDatabase.class, qn);
//     	q.setQuest(quest);
//     	q.setA(ans[0]);
//     	q.setB(ans[1]);
//     	q.setC(ans[2]);
//     	q.setD(ans[3]);
//     	q.setAnsWer(a);
//     	eManager.getTransaction().begin();
// 		eManager.persist(q);
// 		eManager.getTransaction().commit();
//	 }
//	 
//	 
//
//}
