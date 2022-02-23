package tech.makers.tahut.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import tech.makers.tahut.service.StickerService;

@Controller
public class StickersController {

  @Autowired
  StickerService stickerService;

  @GetMapping("/stickers/new")
  public String dummyPage() {   
    return "/stickers/new";
  }

  @PostMapping("/stickers")
  public RedirectView createNewSticker(
        Authentication auth, 
        String eventTitle,
        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate eventDate,
        @DateTimeFormat(pattern = "HH:mm") LocalTime eventStartTime,
        int eventDuration
    ) {
    stickerService.createNewSticker(auth.getName(), eventTitle, eventDate, eventStartTime, eventDuration);       
    return new RedirectView("stickers/new");            
  }
  
}
