package com.fitness.gymManagementSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fitness.gymManagementSystem.bean.GymBook;
@Service
@Repository
public class GymBookDaoImpl implements GymBookDao {
	
	@Autowired
	private GymBookRepository repository;
	@Override
	public void save(GymBook gymBook) {
		// TODO Auto-generated method stub
		repository.save(gymBook);

	}

	@Override
	public Long generateBookingid() {
		Long newId=repository.findLastBookingId();
		if(newId==null)
		{
			newId=1000001L;
		}
		else {
			newId=newId+1L;
		}
		return newId;
	}

	@Override
	public List<GymBook> getBookList() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public GymBook findBookInfoById(Long id) {
		return repository.findById(id).get();
	}
	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	@Override
	public List<GymBook> getEntitiesByUsername(String username){
		return repository.findByUsername(username);
	}
	@Override
	public List<GymBook> findBySlotIdAndUsername(Long id,String username){
		return repository.findBySlotIdAndUsername(id,username);
	}
	@Override
	public Long findItemId(Long bookingId) {
		return repository.findItemId(bookingId);
	}
}
