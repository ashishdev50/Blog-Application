package com.example.SpringPractice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringPractice.Entity.EmailDetails;
@Repository
public interface EmailRepo extends JpaRepository<EmailDetails, Integer> {

}
