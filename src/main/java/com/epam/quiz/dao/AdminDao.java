//package com.epam.quiz.dao;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import org.springframework.stereotype.Repository;
//
//import com.epam.quiz.database.AdminCredentials;
////@Component
//@Repository
//public class AdminDao {
//	public boolean adminDao(AdminCredentials ac) {
//		try {
//			EntityManagerFactory eManagerFactory3= Persistence.createEntityManagerFactory("admin-mysql");
//			EntityManager eManager3=eManagerFactory3.createEntityManager();
//			
//			eManager3.getTransaction().begin();
//			eManager3.persist(ac);
//			eManager3.getTransaction().commit();
//			return true;
//		}catch (Exception e) {
//			return false;
//		}
//	}
//
//}
