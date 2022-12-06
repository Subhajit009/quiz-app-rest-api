package com.epam.quiz.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name = "admincredentials")
public class AdminCredentials {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
		public int id;
		@Column(name="adminusername")
        public String adminUsername;
		
		@Column(name="adminpasscode")
        public int adminPasscode;
        
        
        public int getId() {
    		return id;
    	}
    	public void setId(int id) {
    		this.id = id;
    	}

		public String getAdminUsername() {
			return adminUsername;
		}
		public void setAdminUsername(String adminUsername) {
			this.adminUsername = adminUsername;
		}
		public int getAdminPasscode() {
			return adminPasscode;
		}
		public void setAdminPasscode(int adminPasscode) {
			this.adminPasscode = adminPasscode;
		}
	
      
    }

