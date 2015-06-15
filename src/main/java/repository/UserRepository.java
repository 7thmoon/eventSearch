package repository;

import model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>  {
	//@Query("{ name: ?0, password: ?1}")
	public User findByUsernameAndPassword(String username,  String password);
	public User findByUsername(String username);
}
