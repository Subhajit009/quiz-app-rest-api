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
//import com.epam.quiz.database.QuizDatabase;
//import java.util.*;
////@Component
//@Repository
//public class QuizDao implements QuizDaoInterface{
//    private static Logger logger= LogManager.getLogger(QuizDao.class);
//
//	
//	EntityManagerFactory eManagerFactory1= Persistence.createEntityManagerFactory("question-library");
//    EntityManager eManager1=eManagerFactory1.createEntityManager();
//    
//    EntityManagerFactory eManagerFactory2= Persistence.createEntityManagerFactory("quiz-library");
//    EntityManager eManager2=eManagerFactory2.createEntityManager();
//    
//	public void insertQuizToDatabase(EntityManager e,QuizDatabase q) {
//		e.getTransaction().begin();
//        e.persist(q);
//        e.getTransaction().commit();
//	}
//	
//	 public void delete(EntityManager e,QuizDatabase q) {
//			e.getTransaction().begin();
//	        e.remove(q);
//	        e.getTransaction().commit();
//	        logger.info("Delete Successful");
//		}
//	 
//	 public List<QuizDatabase> getQuiz() {
//			return eManager2.createQuery("select q from QuizDatabase q").getResultList();
//		    
//		}
//}
