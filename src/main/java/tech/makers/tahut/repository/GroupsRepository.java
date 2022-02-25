package tech.makers.tahut.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import tech.makers.tahut.model.Groups;

public interface GroupsRepository extends CrudRepository<Groups, Long> {
  List<Groups> findGroupsByGroupowner(Long groupowner);
}