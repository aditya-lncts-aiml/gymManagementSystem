package com.fitness.gymManagementSystem.dao;

import java.util.List;

import com.fitness.gymManagementSystem.bean.GymItem;



public interface GymItemDao {
	public void saveNewItem(GymItem gymItem);
	public List<GymItem> displayAllItems();
	public GymItem findItemById(Long id);
	public Long generateItemId();
	public void removeItem(Long id);
	public Integer findTotalSeatById(long id);
	}
