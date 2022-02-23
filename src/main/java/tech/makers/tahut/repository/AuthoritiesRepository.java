package tech.makers.tahut.repository;

import org.springframework.data.repository.CrudRepository;

import tech.makers.tahut.model.Authority;

public interface AuthoritiesRepository extends CrudRepository<Authority, Long> {

}
