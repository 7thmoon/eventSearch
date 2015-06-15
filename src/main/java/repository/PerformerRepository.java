package repository;

import model.Performer;

import org.springframework.data.repository.CrudRepository;

public interface PerformerRepository extends CrudRepository<Performer, Long> {
    
}