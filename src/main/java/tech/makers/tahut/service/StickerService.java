package tech.makers.tahut.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
 
}
