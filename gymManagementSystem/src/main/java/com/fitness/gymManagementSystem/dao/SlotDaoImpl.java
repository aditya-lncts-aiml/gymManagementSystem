package com.fitness.gymManagementSystem.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fitness.gymManagementSystem.bean.Slot;
@Repository
@Service
public class SlotDaoImpl implements SlotDao {
	@Autowired
	private SlotRepository repository;

	@Override
	public void saveNewSlot(Slot slot) {
		repository.save(slot);
		// TODO Auto-generated method stub

	}

	@Override
	public List<Slot> displayAllSlot() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	@Override
	public Slot findSlotById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();

	}
	
	@Override
	public Long generateSlotId() {
		Long val=repository.findLastSlotId();
		if(val==null)
			val=1L;

		else
			val=val+1;
		return val;
	}
	
	@Override
	@Transactional
	public void removeSlot(Long id) {
		repository.deleteById(id);;
	}

}
