package tech.makers.tahut.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import tech.makers.tahut.model.Groups;

public interface GroupsRepository extends CrudRepository<Groups, Long> {
  // List<Groups> findByGroupname(String groupname);
  List<Groups> findAllByOrderById();
}