package com.epam.quiz.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epam.quiz.database.QuestionDatabase;

public interface QuestionRepo extends CrudRepository<QuestionDatabase, Integer>{

}
