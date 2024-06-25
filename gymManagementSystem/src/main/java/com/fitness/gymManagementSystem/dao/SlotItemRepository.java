package com.fitness.gymManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.gymManagementSystem.bean.SlotItem;
import com.fitness.gymManagementSystem.bean.SlotItemEmbed;

public interface SlotItemRepository extends JpaRepository<SlotItem, SlotItemEmbed>{

}
