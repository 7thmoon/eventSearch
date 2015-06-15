package repository;


import model.Venue;

import org.springframework.data.repository.CrudRepository;
public interface VenueRepository extends CrudRepository<Venue, Long> {
	
}