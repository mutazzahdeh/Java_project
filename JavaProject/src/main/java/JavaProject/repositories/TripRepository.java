package JavaProject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import JavaProject.models.Trip;
import JavaProject.models.Users;

public interface TripRepository extends CrudRepository<Trip, Long>{
	List<Trip> findAll();
	List<Trip> findByUserContains(Users u);

}
