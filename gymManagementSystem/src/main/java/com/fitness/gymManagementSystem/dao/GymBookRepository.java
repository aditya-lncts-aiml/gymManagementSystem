package com.fitness.gymManagementSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fitness.gymManagementSystem.bean.GymBook;

public interface GymBookRepository extends JpaRepository<GymBook, Long>{
	@Query("select max(bookingId) from GymBook")
	public Long findLastBookingId();
	
	List<GymBook> findByUsername(String username);
	List<GymBook> findBySlotIdAndUsername(Long id,String username);
}
