package repository;



import java.util.List;

import model.Booking;
import model.User;

import org.springframework.data.repository.CrudRepository;


public interface BookingRepository extends CrudRepository<Booking, Long> {
	//public Booking findOne(String id);
	public List<Booking> findByUser(User user);
	public Booking deleteById(String id);
}