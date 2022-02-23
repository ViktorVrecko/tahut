package tech.makers.tahut.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.makers.tahut.model.Sticker;

public interface StickersRepository extends JpaRepository<Sticker, Long> {
  
}
