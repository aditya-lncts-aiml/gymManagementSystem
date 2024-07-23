package com.fitness.gymManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.gymManagementSystem.bean.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, String > {
}
