package com.app.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.quizapp.entity.Quiz;
@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

	//List<Quiz> findAllByOrderBySerialNumberAsc();
}
