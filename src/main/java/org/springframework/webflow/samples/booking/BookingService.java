package org.springframework.webflow.samples.booking;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.webflow.samples.booking.config.MongoConfig;

import repository.BookingRepository;
import repository.EventRepository;
import repository.UserRepository;
import model.Booking;
import model.Event;
import model.User;

/**
 * A service class for retrieving hotels and bookings from a backing repository. Also supports the ability to cancel
 * a booking.
 */
@Service("bookingService")
public class BookingService {

    /**
     * Find bookings made by the given user
     * @param username the user's name
     * @return their bookings
     */
    public List<Booking> findBookings(String username){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		BookingRepository bookRepo = ctx.getBean(BookingRepository.class);
		UserRepository userRepo = ctx.getBean(UserRepository.class);
		User user = userRepo.findByUsername(username);
		List<Booking> res = bookRepo.findByUser(user);
		ctx.close();
		return res;
    }


    public Booking createBooking(Long eventId, String username){
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		BookingRepository bookRepo = ctx.getBean(BookingRepository.class);
		EventRepository eventRepo = ctx.getBean(EventRepository.class);
		UserRepository userRepo = ctx.getBean(UserRepository.class);
		Event event = eventRepo.findOne(eventId);
		User user = userRepo.findByUsername(username);
		Booking booking = new Booking(event, user);
		bookRepo.save(booking);
		ctx.close();
		return booking;
    }

    /**
     * Persist the booking to the database
     * @param booking the booking
     */
    public void persistBooking(Booking booking){
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		BookingRepository bookRepo = ctx.getBean(BookingRepository.class);
		bookRepo.save(booking);
		ctx.close();
    }

    /**
     * Cancel an existing booking.
     * @param id the booking id
     */
    public void cancelBooking(String id){
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		BookingRepository bookRepo = ctx.getBean(BookingRepository.class);
		bookRepo.deleteById(id);
		ctx.close();
    }

}
