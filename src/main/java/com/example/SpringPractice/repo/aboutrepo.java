package com.example.SpringPractice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringPractice.Entity.About;
@Repository
public interface aboutrepo extends JpaRepository<About, Integer> {

}
