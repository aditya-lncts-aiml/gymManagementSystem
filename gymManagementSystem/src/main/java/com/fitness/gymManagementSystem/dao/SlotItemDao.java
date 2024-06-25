package com.fitness.gymManagementSystem.dao;

import java.util.List;

import com.fitness.gymManagementSystem.bean.SlotItem;
import com.fitness.gymManagementSystem.bean.SlotItemEmbed;

public interface SlotItemDao {
	public void saveNewSlotItem(SlotItem slotItem);
	public List<SlotItem> displayAllItem();
	public SlotItem findItemById(SlotItemEmbed id);
}
