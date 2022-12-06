package com.epam.quiz.database;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component
public class UserCredentials {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
		public int id;
        String userUsername;
         int userPasscode;
        
        public int getId() {
    		return id;
    	}
    	public void setId(int id) {
    		this.id = id;
    	}
		public String getUserUsername() {
			return userUsername;
		}
		public void setUserUsername(String userUsername) {
			this.userUsername = userUsername;
		}
		public int getUserPasscode() {
			return userPasscode;
		}
		public void setUserPasscode(int userPasscode) {
			this.userPasscode = userPasscode;
		}
            
    }

