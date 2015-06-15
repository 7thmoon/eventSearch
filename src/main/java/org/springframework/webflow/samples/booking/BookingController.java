package org.springframework.webflow.samples.booking;

import java.security.Principal;
import java.util.List;

import model.Booking;
import model.SearchCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingController {
	private BookingService bookingService;
	
	@Autowired
    public BookingController(BookingService bookingService ) {
	this.bookingService = bookingService;
    }
	
	@RequestMapping(value = "/events/search", method = RequestMethod.GET)
	public void search(SearchCriteria searchCriteria, Principal currentUser, Model model) {
		if (currentUser != null) {
		    List<Booking> booking = bookingService.findBookings(currentUser.getName());
		    model.addAttribute(booking);
		}
	}

    @RequestMapping(value = "/bookings/{id}", method = RequestMethod.DELETE)
    public String deleteBooking(@PathVariable String id, Model model) {
    	bookingService.cancelBooking(id);
    	return "redirect:../events/search";
    }
}
