package tech.makers.tahut.repository;

import org.springframework.data.repository.CrudRepository;
import tech.makers.tahut.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);
}
