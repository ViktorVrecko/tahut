package tech.makers.tahut.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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

    Sticker newSticker = stickerService.createNewSticker("admin", "Meeting with Freddy", date, time, 2, null);    

    assertEquals(newSticker.getFkAuthor(), "admin");
    assertEquals(newSticker.getContent(), "Meeting with Freddy");
  }

  @Test
  public void returnsListOfMyStickersOrderedByDate() {

    LocalDate date = LocalDate.of(2022, 02, 25);
    LocalTime time = LocalTime.of(18, 07);
    
    Sticker closeByEvent = stickerService.createNewSticker("admin", "Meet for a Beer", date.plusDays(1), time, 1, null);
    Sticker farAwayEvent = stickerService.createNewSticker("admin", "Begin of vacation", date.plusMonths(3), time, 1, null);
    Sticker inTheMiddleEvent = stickerService.createNewSticker("admin", "Meet for a Beer", date.plusMonths(1), time, 1, null);

    List<Sticker> myEvents = stickerService.getStickersByAuthorOrderByDate("admin");    

    int indexCloseByEvent = myEvents.indexOf(closeByEvent);
    int indexFarAwayEvent = myEvents.indexOf(farAwayEvent);
    int indexInTheMiddleEvent = myEvents.indexOf(inTheMiddleEvent);

    assertTrue(indexCloseByEvent < indexInTheMiddleEvent);
    assertTrue(indexInTheMiddleEvent < indexFarAwayEvent);    
  }

  @Test
  public void deleteStickers() {
    LocalDate date = LocalDate.of(2022, 02, 25);
    LocalTime time = LocalTime.of(18, 07);

    Sticker deleteSticker = stickerService.createNewSticker("admin", "I will be deleted", date, time, 1, null);
    Sticker notDeleteSticker = stickerService.createNewSticker("admin", "I will not be deleted", date, time, 1, null);

    stickerService.deleteSticker("admin", deleteSticker.getId());
    stickerService.deleteSticker("i am not the author of this sticker", notDeleteSticker.getId());
    List<Sticker> myEvents = stickerService.getStickersByAuthorOrderByDate("admin");
        
    assertFalse(myEvents.contains(deleteSticker));
    assertTrue(myEvents.contains(notDeleteSticker));
  }

  @Test
  public void updateSticker() {

    LocalDate date = LocalDate.of(2022, 02, 25);
    LocalTime time = LocalTime.of(18, 07);

    Sticker newSticker = stickerService.createNewSticker("admin", "Meeting with Freddy", date, time, 2, null);   
    
    Sticker updatedSticker = stickerService.updateSticker("admin", newSticker.getId(), "Meeting with Alex", date, time, 4, null);
    
    assertEquals(updatedSticker.getContent(), "Meeting with Alex");
    assertEquals(updatedSticker.getDuration(), 4);
    assertEquals(newSticker.getId(), updatedSticker.getId());
    
  }


}
