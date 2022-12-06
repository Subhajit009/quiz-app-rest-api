package com.epam.quiz.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epam.quiz.database.QuizDatabase;

public interface QuizRepo extends CrudRepository<QuizDatabase, Integer>{

}
