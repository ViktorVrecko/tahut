package tech.makers.tahut.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.makers.tahut.model.Sticker;

public interface StickersRepository extends JpaRepository<Sticker, Long> {

  List<Sticker> findByFkAuthorOrderByEventDate(String author);

  List<Sticker> findByFkGroupIdOrderByEventDate(Long groupId);

  Sticker findByIdAndFkAuthor(Long id, String author);
 
}
