package com.fitness.gymManagementSystem.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fitness.gymManagementSystem.bean.GymItem;
@Repository
@Service
public class GymItemDaoImpl implements GymItemDao {
	@Autowired
	private GymItemRepository repository;
	
	
	@Override
	public void saveNewItem(GymItem gymItem) {
		repository.save(gymItem);
		// TODO Auto-generated method stub

	}

	@Override
	public List<GymItem> displayAllItems() {
		return repository.findAll();
		// TODO Auto-generated method stub
	}

	@Override
	public GymItem findItemById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
	
	@Override
	public Long generateItemId() {
		Long val=repository.findLastItemId();
		if(val==null)
			val=101L;

		else
			val=val+1;
		return val;
	}
	
	@Override
	@Transactional
	public void removeItem(Long id) {
		repository.deleteById(id);
	}
	
	@Override
	public Integer findTotalSeatById(long id) {
		return repository.findTotalSeatById(id);
	}
	
	@Override
	public String findItemName(Long itemId) {
		return repository.findItemName(itemId);
	}

}
