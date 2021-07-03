package JavaProject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



import JavaProject.models.Users;

public interface UsersRepository extends CrudRepository<Users, Long>{
	 Users findByEmail(String email);
	    List<Users> findAll();

}
