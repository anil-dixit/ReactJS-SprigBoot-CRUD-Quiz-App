package com.app.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.quizapp.entity.Question;

@Repository
public interface QuestionDao extends CrudRepository<Question,Integer> {

	List<Question> findByCategory(String category);

	@Query(value="select * from question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, Integer numQ);
}
