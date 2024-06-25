package com.fitness.gymManagementSystem.dao;

import java.util.List;

import com.fitness.gymManagementSystem.bean.Slot;

public interface SlotDao {
	public void saveNewSlot(Slot slot);
	public List<Slot> displayAllSlot();
	public Slot findSlotById(Long id);
	public Long generateSlotId();
	public void removeSlot(Long id);
}
