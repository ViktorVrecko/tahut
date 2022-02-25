package tech.makers.tahut.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.makers.tahut.model.Sticker;
import tech.makers.tahut.repository.StickersRepository;

@Service
public class StickerService {

  @Autowired
  StickersRepository stickersRepository;

  public Sticker createNewSticker(String authorName, String eventTitle, LocalDate eventDate, LocalTime eventStartTime,
      int eventDuration) {

        Sticker newSticker = new Sticker();
        newSticker.setFkAuthor(authorName);
        newSticker.setContent(eventTitle);
        newSticker.setDuration(eventDuration);
        newSticker.setEventDate(LocalDateTime.of(eventDate, eventStartTime));

        return stickersRepository.save(newSticker);               
  }

  public Sticker updateSticker(String authorName, Long id, String eventTitle, LocalDate eventDate, LocalTime eventStartTime,
  int eventDuration ) {
    Sticker toUpdate = stickersRepository.findById(id).get();

    if ( !toUpdate.getFkAuthor().equals(authorName) ) {
      return null;
    }

    toUpdate.setContent(eventTitle);
    toUpdate.setEventDate(LocalDateTime.of(eventDate, eventStartTime));
    toUpdate.setDuration(eventDuration);

    return stickersRepository.save(toUpdate);
  }

  public void deleteSticker(String authorName, Long id) {
    Sticker toDelete = stickersRepository.findById(id).get();

    if ( !toDelete.getFkAuthor().equals(authorName) ) {
      return;
    }

    stickersRepository.deleteById(id);        
  }

  public Sticker getStickerByAuthorAndId(String authorName, Long id) {
    Sticker returnSticker = stickersRepository.findById(id).get();

    if (!returnSticker.getFkAuthor().equals(authorName)) {
      return null;
    }

    return returnSticker;
  }

  public List<Sticker> getStickersByAuthorOrderByDate(String author) {
    return stickersRepository.findByFkAuthorOrderByEventDate(author);
  }
 
}
