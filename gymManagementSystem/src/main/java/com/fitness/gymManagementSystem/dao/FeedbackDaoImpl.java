package com.fitness.gymManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fitness.gymManagementSystem.bean.Feedback;
@Service
@Repository
public class FeedbackDaoImpl implements FeedbackDao {
	
	@Autowired
	private FeedbackRepository repository;
	@Override
	public void save(Feedback feedback) {
		repository.save(feedback);

	}
	@Override
	public Long generateFeedbackId() {
		Long newId=repository.findLastFeedbackId();
		if(newId==null)
		{
			newId=100000001L;
		}
		else {
			newId=newId+1L;
		}
		return newId;
	}

}
