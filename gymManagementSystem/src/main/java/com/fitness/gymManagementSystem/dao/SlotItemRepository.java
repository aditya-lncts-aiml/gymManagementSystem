package com.fitness.gymManagementSystem.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fitness.gymManagementSystem.bean.SlotItem;
import com.fitness.gymManagementSystem.bean.SlotItemEmbed;

public interface SlotItemRepository extends JpaRepository<SlotItem, SlotItemEmbed>{
	@Query("SELECT seatBooked from SlotItem a where embeddedId=?1")
	public Integer findSeatBookedById(SlotItemEmbed id);
	
	@Query("SELECT embeddedId from SlotItem")
	public Set<SlotItemEmbed> findAllEmbeds();
	
	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM SlotItem s WHERE s.embeddedId.itemId = ?1")
    boolean existsByItemId(Long itemId);
}
