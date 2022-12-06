package com.epam.quiz.database;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
@Entity
@Table(name = "quizlibrary")
public class QuizDatabase {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;
     String quest;
     String a;
     String b;
     String c;
     String d;
     @Column(name="answer")
     char ansWer;
     int marks;
    
     
public QuizDatabase() {
		 
	 }
	 public QuizDatabase(int id,String title,String a,String b, String c,String d,char ans,int m) {
		 this.id=id;
		 quest =title;
		 this.a=a;
		 this.b=b;
		 this.c=c;
		 this.d=d;
		 ansWer=ans;
		 marks=m;
	 }
    
    public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
    
    public int getId() 
    {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuest() {
		return quest;
	}
	public void setQuest(String quest) {
		this.quest = quest;
	}
	public char getAnsWer() {
		return ansWer;
	}
	public void setAnsWer(char ansWer) {
		this.ansWer = ansWer;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
}
