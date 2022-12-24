package com.example.SpringPractice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.SpringPractice.Entity.Comments;
import com.example.SpringPractice.Entity.EmailDetails;
@Repository
public interface CommentRepo extends JpaRepository<Comments, Integer> {


	

	
	
//	List<Product> findAllByCategory_Id(int id);
	
	List<Comments> findAllByBlog_Id(int id);
}
