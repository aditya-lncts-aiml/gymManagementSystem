package com.fitness.gymManagementSystem.dao;

import java.util.List;

import com.fitness.gymManagementSystem.bean.Feedback;

public interface FeedbackDao {
	public void save(Feedback feedback);
	public List<Feedback> getFeedbackList();
}
