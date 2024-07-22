package com.fitness.gymManagementSystem.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fitness.gymManagementSystem.bean.Feedback;
import com.fitness.gymManagementSystem.bean.GymBook;
import com.fitness.gymManagementSystem.bean.GymItem;
import com.fitness.gymManagementSystem.bean.Item;
import com.fitness.gymManagementSystem.bean.Slot;
import com.fitness.gymManagementSystem.bean.SlotItem;
import com.fitness.gymManagementSystem.bean.SlotItemEmbed;
import com.fitness.gymManagementSystem.dao.FeedbackDao;
import com.fitness.gymManagementSystem.dao.GymBookDao;
import com.fitness.gymManagementSystem.dao.GymItemDao;
import com.fitness.gymManagementSystem.dao.SlotDao;
import com.fitness.gymManagementSystem.dao.SlotItemDao;
import com.fitness.gymManagementSystem.exception.SeatNotAvailableException;
import com.fitness.gymManagementSystem.service.GymItemService;
import com.fitness.gymManagementSystem.service.GymUserService;

@RestController
public class GymController {
	
	@Autowired
	private GymBookDao gymBookDao;
	
    @Autowired
    private GymItemDao gymItemDao;
    
    @Autowired
    private SlotDao slotDao;
    
    @Autowired
    private SlotItemDao slotItemDao;
    
    @Autowired
    private GymItemService itemService;
    
    @Autowired
    private GymUserService userService;
    
    @Autowired
    private FeedbackDao feedbackDao;
    
    @GetMapping("/index")
    public ModelAndView showIndex() {
    	String indexPage="";
    	String userType=userService.getType(); 
    	if(userType.equalsIgnoreCase("Admin"))
    		indexPage="index1";
    	else if(userType.equalsIgnoreCase("Customer"))
    		indexPage="index2";
    	ModelAndView mv=new ModelAndView(indexPage);
    	return mv;
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
    	return new ModelAndView("redirect:/index");
    }    
    @GetMapping("/gymitems")
    public ModelAndView showItemReportPage() {
    	List<GymItem> itemList=gymItemDao.displayAllItems();
    	if(!itemList.isEmpty()) {
    		ModelAndView mv=new ModelAndView("gymItemReportPage");
        	mv.addObject("itemList",itemList);
        	return mv;
    	}
    	else {
    		throw new SeatNotAvailableException("No Gym Item Available");
    	}
    }
    /*@GetMapping("/deleteitem/{id}")
    public ModelAndView deleteItem(@PathVariable Long id) {
        gymItemDao.removeItem(id);
        ModelAndView mv = new ModelAndView("redirect:index");
        return mv;
    }*/ 
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
    	List<GymItem> itemList=gymItemDao.displayAllItems();
    	for(GymItem item:itemList) {
    		SlotItemEmbed embed=new SlotItemEmbed(slot.getSlotId(),item.getItemId());
    		SlotItem slotItem=new SlotItem(embed);
    		slotItemDao.save(slotItem);
    	}
    	return new ModelAndView("redirect:/index");
    }
    @GetMapping("/slotreport")
    public ModelAndView showSlotReportPage() {
    	List<Slot> slotList=slotDao.displayAllSlot();
    	if(!slotList.isEmpty()) {
        	ModelAndView mv=new ModelAndView("slotReportPage");
        	mv.addObject("slotList",slotList);
        	return mv;
    	}
    	else {
    		throw new SeatNotAvailableException("No Slots Available");
    	}
    }    
    @GetMapping("/slot-book/{id}")
    public ModelAndView showSlotBookPage(@PathVariable Long id){
    	String fname="";
    	String userType=userService.getType();
    	if(userType.equalsIgnoreCase("Admin"))
    		fname="slotBookPage1";
    	else if(userType.equalsIgnoreCase("Customer"))
    		fname="slotBookPage2";
    	Slot slot=slotDao.findSlotById(id);
    	List<Item> itemList=itemService.getItemList(id);
    	ModelAndView mv=new ModelAndView(fname);
    	mv.addObject("slot", slot);
    	mv.addObject("itemList",itemList);
    	if(userType.equalsIgnoreCase("Admin")) {
    		List<String> userList=userService.getAllCustomers();
    		mv.addObject("userList",userList);
    	}
    	return mv;
    }
    @PostMapping("/slot-book")
    public ModelAndView saveSlotBookPage(@RequestParam("slot_id") Long slotId,@RequestParam("selectItem") Long itemId,@RequestParam("userId") String userId) {
    	String userType=userService.getType();
    	String username="";
        if (userId != null && !userId.isEmpty()) {
        	if(userType.equalsIgnoreCase("Admin")) {
        		username=userId;
        	}
        } else {
        	username=userService.getUser().getUsername();
        }
        List<GymBook> book=gymBookDao.findBySlotIdAndUsername(slotId,username);
        if(book.isEmpty()) {
        	GymItem gymItem=gymItemDao.findItemById(itemId);
        	SlotItemEmbed embed=new SlotItemEmbed(slotId,itemId);
        	int totalSeat=gymItem.getTotalSeat();
        	SlotItem slotItem=slotItemDao.findItemById(embed);
        	int seatBooked=slotItemDao.findSeatBookedById(embed);
        	int available=totalSeat-seatBooked;
        	GymBook gymBook=null;
        	if(available>0) {
        		long bookingId=gymBookDao.generateBookingid();
        		seatBooked++;
        		slotItem.setSeatBooked(seatBooked);
        		gymBook=new GymBook(bookingId,slotId,itemId,username);
        		gymBookDao.save(gymBook);
        		slotItemDao.save(slotItem);
        	}
        	else {
        		throw new SeatNotAvailableException("Seat Not Available");
        	}
        	 return new ModelAndView("redirect:/book-success/" + gymBook.getBookingId());
        }
        else {
        	throw new SeatNotAvailableException("You have booked slot in this timing  change the slot or cancel your booking");
        }
    }
    @GetMapping("/book-success/{bookingId}")
    public ModelAndView showSuccessPage(@PathVariable Long bookingId) {
        GymBook booking = gymBookDao.findBookInfoById(bookingId);
        String itemName=gymItemDao.findItemName(gymBookDao.findItemId(bookingId));
        ModelAndView mv = new ModelAndView("bookingSuccessPage");
        mv.addObject("booking", booking);
        mv.addObject("itemName", itemName);
        return mv;
    }
    @GetMapping("/slot-item-add/{id}")
    	public ModelAndView saveItemSlots(@PathVariable Long id) {
    	List<Slot> slot=slotDao.displayAllSlot();
    	if(!slot.isEmpty()) {
        	itemService.addNewItemToSlots(id);
        	return new ModelAndView("redirect:/index");
    	}
    	else {
    		throw new SeatNotAvailableException("No Slots available");
    	}
    }
    @GetMapping("/booked")
    public ModelAndView showBookingPage() {
    	String username="";
    	String userType=userService.getType();
    	List<GymBook> bookList=gymBookDao.getBookList();
    	if(userType.equalsIgnoreCase("Customer")) {
    		username=userService.getUser().getUsername();
            bookList=gymBookDao.getEntitiesByUsername(username);
    	}
    	if(!bookList.isEmpty()) {
    		ModelAndView mv=new ModelAndView("bookedSlotPage");
        	mv.addObject("gbList", bookList);
        	return mv;
    	}
    	else {
    		throw new SeatNotAvailableException("You have not Booked any slot");
    	}
    }
    @PostMapping("/booked")
    public ModelAndView cancelBooking(@RequestParam("selectBookingId") Long bookingId) {
        GymBook gymBook = gymBookDao.findBookInfoById(bookingId);    
        if (gymBook != null) {
            SlotItemEmbed embed = new SlotItemEmbed(gymBook.getSlotId(), gymBook.getItemId());
            SlotItem slotItem = slotItemDao.findItemById(embed);
            if (slotItem != null) {
                int seatBooked = slotItem.getSeatBooked();
                if (seatBooked > 0) {
                    seatBooked--;
                    slotItem.setSeatBooked(seatBooked);
                    slotItemDao.save(slotItem);
                    gymBookDao.deleteById(bookingId);
                }
            }
        }

        return new ModelAndView("redirect:/index");
    }
    @GetMapping("/feedback")
    public ModelAndView showFeedbackForm() {
        Feedback fb=new Feedback();
        Long newId=feedbackDao.generateFeedbackId();
        fb.setId(newId);
        ModelAndView mv = new ModelAndView("feedbackFormPage");
        mv.addObject("feedback", fb);
        return mv;
    }
    @PostMapping("/submit-feedback")
    public ModelAndView submitFeedback(@ModelAttribute("feedback") Feedback feedback) {
        feedbackDao.save(feedback);
        return new ModelAndView("redirect:/feedback-success");
    }
    @GetMapping("/feedback-success")
    public ModelAndView showFeedbackSuccess() {
        return new ModelAndView("feedbackSuccessPage");
    }
    @ExceptionHandler(SeatNotAvailableException.class)
      public ModelAndView handleSeatNotFoundException(SeatNotAvailableException exception){
    	ModelAndView mv = new ModelAndView("exceptionPage");
        mv.addObject("errorMessage", exception.getMessage());
        return mv;
      }
    
    
}


