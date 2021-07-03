package JavaProject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import JavaProject.models.City;

public interface CityRepository extends CrudRepository<City, Long> {
	 List<City> findAll();

}
