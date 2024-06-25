package com.fitness.gymManagementSystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.fitness.gymManagementSystem.bean.GymItem;
import com.fitness.gymManagementSystem.bean.Slot;
import com.fitness.gymManagementSystem.dao.GymItemDao;
import com.fitness.gymManagementSystem.dao.SlotDao;

@RestController
public class GymController {

    @Autowired
    private GymItemDao gymItemDao;
    
    @Autowired
    private SlotDao slotDao;

    @GetMapping("/index")
    public ModelAndView showIndex() {
        return new ModelAndView("index");
    }

    @GetMapping("/gymitem")
    public ModelAndView showItemEntryPage() {
        GymItem gymItem = new GymItem();
        Long newId=gymItemDao.generateItemId();
        List<GymItem> itemList=gymItemDao.displayAllItems();
        gymItem.setItemId(newId);
        ModelAndView mv = new ModelAndView("gymItemEntryPage");
        mv.addObject("itemRecord", gymItem);
        mv.addObject("itemList",itemList);
        return mv;
    }
    @PostMapping("/gymitem")
    public ModelAndView saveItemEntryPage(@ModelAttribute("itemRecord") GymItem gymItem) {
    	gymItemDao.saveNewItem(gymItem);
    	return new ModelAndView("index");
    }
    
    @GetMapping("/gymitems")
    public ModelAndView showItemReportPage() {
    	List<GymItem> itemList=gymItemDao.displayAllItems();
    	ModelAndView mv=new ModelAndView("gymItemReportPage");
    	mv.addObject("itemList",itemList);
    	return mv;
    }
    @PostMapping("/gymitems")
    public ModelAndView deleteItem(@RequestParam("id") Long itemId) {
        gymItemDao.removeItem(itemId);
        ModelAndView mv = new ModelAndView("gymItemReportPage");
        return mv;
    }
    
    @GetMapping("/slotentry")
    public ModelAndView showSlotEntryPage() {
        Slot slot = new Slot();
        Long newId=slotDao.generateSlotId();
        List<Slot> slotList=slotDao.displayAllSlot();
        slot.setSlotId(newId);
        ModelAndView mv = new ModelAndView("slotEntryPage");
        mv.addObject("slotList", slotList);
        mv.addObject("slotRecord", slot);
        return mv;
    }
    @PostMapping("/slotentry")
    public ModelAndView saveSlotEntryPage(@ModelAttribute("slotRecord") Slot slot) {
    	slotDao.saveNewSlot(slot);
    	return new ModelAndView("index");
    }
    
    
    @GetMapping("/slotreport")
    public ModelAndView showSlotReportPage() {
    	List<Slot> slotList=slotDao.displayAllSlot();
    	ModelAndView mv=new ModelAndView("slotReportPage");
    	mv.addObject("slotList",slotList);
    	return mv;
    }
    
    @PostMapping("/slotreport")
    public ModelAndView deleteSlot(@RequestParam("id") Long slotId) {
        slotDao.removeSlot(slotId);
        ModelAndView mv = new ModelAndView("slotReportPage");
        return mv;
    }
    
}
