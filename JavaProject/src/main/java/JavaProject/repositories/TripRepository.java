package JavaProject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import JavaProject.models.Trip;

public interface TripRepository extends CrudRepository<Trip, Long>{
	List<Trip> findAll();

}
