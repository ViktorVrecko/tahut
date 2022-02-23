package tech.makers.tahut.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.makers.tahut.TahutApplication;
import tech.makers.tahut.model.Sticker;
import tech.makers.tahut.service.StickerService;

@SpringBootTest(classes = TahutApplication.class)
public class StickerServiceTest {

  @Autowired
  StickerService stickerService;

  @Test
  public void createsNewSticker() {
    
    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();

    Sticker newSticker = stickerService.createNewSticker("admin", "Meeting with Freddy", date, time, 2);    

    assertEquals(newSticker.getFkAuthor(), "admin");
    assertEquals(newSticker.getContent(), "Meeting with Freddy");
  }

}
