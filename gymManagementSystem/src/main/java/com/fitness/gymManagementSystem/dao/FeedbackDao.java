package com.fitness.gymManagementSystem.dao;

import com.fitness.gymManagementSystem.bean.Feedback;

public interface FeedbackDao {
	public void save(Feedback feedback);
	public Long generateFeedbackId();
}
