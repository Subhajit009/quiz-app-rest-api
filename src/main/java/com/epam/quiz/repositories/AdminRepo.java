package com.epam.quiz.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epam.quiz.database.AdminCredentials;

public interface AdminRepo extends CrudRepository<AdminCredentials, Integer>{
	AdminCredentials findByAdminUsername(String adminusername);

}
