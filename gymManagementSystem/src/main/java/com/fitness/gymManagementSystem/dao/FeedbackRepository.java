package com.fitness.gymManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fitness.gymManagementSystem.bean.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	@Query("select max(id) from Feedback")
	public Long findLastFeedbackId();
}
