package com.fitness.gymManagementSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fitness.gymManagementSystem.bean.SlotItem;
import com.fitness.gymManagementSystem.bean.SlotItemEmbed;
@Repository
@Service
public class SlotItemDaoImpl implements SlotItemDao {
	@Autowired
	private SlotItemRepository repository;
	
	@Override
	public void saveNewSlotItem(SlotItem slotItem) {
		repository.save(slotItem);

	}

	@Override
	public List<SlotItem> displayAllItem() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public SlotItem findItemById(SlotItemEmbed id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

}
