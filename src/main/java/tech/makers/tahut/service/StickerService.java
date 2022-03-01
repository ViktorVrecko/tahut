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

  @Autowired
  GroupService groupService;

  public Sticker createNewSticker(String authorName, String eventTitle, LocalDate eventDate, LocalTime eventStartTime,
      int eventDuration, Long eventGroup) {

        Sticker newSticker = new Sticker();
        newSticker.setFkAuthor(authorName);
        newSticker.setContent(eventTitle);
        newSticker.setDuration(eventDuration);
        newSticker.setEventDate(LocalDateTime.of(eventDate, eventStartTime));
        newSticker.setFkGroupId(eventGroup);

        return stickersRepository.save(newSticker);               
  }

  public Sticker updateSticker(String authorName, Long id, String eventTitle, LocalDate eventDate, LocalTime eventStartTime,
  int eventDuration ) {
    Sticker stickerToUpdate = stickersRepository.findByIdAndFkAuthor(id, authorName);
    
    if (stickerToUpdate == null) 
      return null;

    stickerToUpdate.setContent(eventTitle);
    stickerToUpdate.setEventDate(LocalDateTime.of(eventDate, eventStartTime));
    stickerToUpdate.setDuration(eventDuration);

    return stickersRepository.save(stickerToUpdate);
  }

  public void deleteSticker(String requester, Long id) {
    Sticker stickerToDelete = stickersRepository.findByIdAndFkAuthor(id, requester);
    
    if (stickerToDelete == null) 
      return;

    stickersRepository.deleteById(stickerToDelete.getId());        
  }

  public Sticker getStickerByAuthorAndId(String authorName, Long id) {
    Sticker returnSticker = stickersRepository.findByIdAndFkAuthor(id, authorName);
    return returnSticker;
  }

  public List<Sticker> getStickersByAuthorOrderByDate(String author) {
    return stickersRepository.findByFkAuthorOrderByEventDate(author);
  }

  public List<Sticker> getStickersByGroupOrderByDate(String requester, Long groupId) {
    boolean isRequesterInGroup = groupService.isUserInGroup(requester, groupId);

    if (!isRequesterInGroup) return null;

    return stickersRepository.findByFkGroupIdOrderByEventDate(groupId);
  }
 
}
