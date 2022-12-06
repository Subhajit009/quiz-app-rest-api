package com.epam.quiz.database;

import javax.persistence.*;


@Entity
@Table(name = "questionlibrary")
//@Component
//@Scope("prototype")
public class QuestionDatabase {
	
	
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
	 
	 public QuestionDatabase() {
		 
	 }
	 public QuestionDatabase(int id,String title,String a,String b, String c,String d,char ans) {
		 this.id=id;
		 quest =title;
		 this.a=a;
		 this.b=b;
		 this.c=c;
		 this.d=d;
		 ansWer=ans;
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
	@Override
	public String toString() {
		return "QuestionDatabase [id=" + id + ", quest=" + quest + ", a=" + a + ", b=" + b + ", c=" + c + ", d=" + d
				+ ", ansWer=" + ansWer + "]";
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

}
