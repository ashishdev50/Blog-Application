package com.example.SpringPractice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringPractice.Entity.User;
@Repository
public interface userepo extends JpaRepository<User, Integer> {

}
