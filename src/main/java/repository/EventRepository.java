package repository;


import model.Event;




import org.springframework.data.repository.CrudRepository;


public interface EventRepository extends CrudRepository<Event, Long> {
	public Event findOne(Long id);
}