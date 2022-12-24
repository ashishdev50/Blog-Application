package com.example.SpringPractice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.SpringPractice.Entity.Blog;
import com.example.SpringPractice.Entity.Comments;
@Repository
public interface blogrepo  extends JpaRepository<Blog, Integer>{
	
	
}
