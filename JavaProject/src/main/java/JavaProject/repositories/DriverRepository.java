package JavaProject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



import JavaProject.models.Driver;

public interface DriverRepository extends CrudRepository<Driver, Long> {
	 Driver findByEmail(String email);
	    List<Driver> findAll();

}
