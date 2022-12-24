package com.example.SpringPractice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringPractice.Entity.Subscibe;
@Repository
public interface SubScriberepo extends JpaRepository<Subscibe, Integer>{

	
	//search
	public List<Subscibe> findByEmail(String email);
}
