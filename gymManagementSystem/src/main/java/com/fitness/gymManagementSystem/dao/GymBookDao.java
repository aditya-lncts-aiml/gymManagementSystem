package com.fitness.gymManagementSystem.dao;

import java.util.List;

import com.fitness.gymManagementSystem.bean.GymBook;

public interface GymBookDao {
	public void save(GymBook gymBook);
	public Long generateBookingid();
	public List<GymBook> getBookList();
	public GymBook findBookInfoById(Long id);
	public void deleteById(long id);
	public List<GymBook> getEntitiesByUsername(String username);
	public List<GymBook> findBySlotIdAndUsername(Long id,String username);
}
