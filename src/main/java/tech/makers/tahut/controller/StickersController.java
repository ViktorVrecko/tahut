package tech.makers.tahut.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import tech.makers.tahut.model.Sticker;
import tech.makers.tahut.service.GroupService;
import tech.makers.tahut.service.StickerService;

@Controller
@RequestMapping("/stickers")
public class StickersController {

  @Autowired
  StickerService stickerService;

  @Autowired
  GroupService groupService;
    
  @GetMapping
  public String showMyStickers(
      Authentication auth, 
      Model model, 
      @RequestParam(required=false) Integer month,
      @RequestParam(required=false) Long group
    ) {   

    if (month == null || month < 1 || month > 12) {
      month = LocalDate.now().getMonthValue();
    }

    List<Sticker> stickers;
    if (group == null) {
      stickers = stickerService.getStickersByAuthorOrderByDate(auth.getName());
    } else {
      stickers = stickerService.getStickersByGroupOrderByDate(auth.getName(), group);
    }  

    model.addAttribute("currentMonthValue", month); 
    model.addAttribute("dateToday", LocalDate.now());
    model.addAttribute("monthEnumArray", Month.values());
    model.addAttribute("myStickers", stickers);  
    model.addAttribute("myGroupMemberships", groupService.getMembershipsByUsername(auth.getName()) );
    return "/stickers/index";
  }

  @GetMapping("edit/{id}") 
  public String showUpdateForm(Authentication auth, Model model, @PathVariable("id") Long id) {
    model.addAttribute("stickerToEdit", stickerService.getStickerByAuthorAndId(auth.getName(), id));
    model.addAttribute("dateToday", LocalDate.now());
    model.addAttribute("myGroupMemberships", groupService.getMembershipsByUsername(auth.getName()) );
    return "/stickers/edit";
  }

  @DeleteMapping("{id}")
  public RedirectView deleteSticker(Authentication auth, @PathVariable("id") Long id) {
    stickerService.deleteSticker(auth.getName(), id);
    return new RedirectView("/stickers"); 
  }

  @PatchMapping("{id}")
  public RedirectView updateSticker(
      Authentication auth,
      @PathVariable("id") Long id,
      String eventTitle,
      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate eventDate,
      @DateTimeFormat(pattern = "HH:mm") LocalTime eventStartTime,
      int eventDuration,
      Long eventGroup
    ) {
    stickerService.updateSticker(auth.getName(), id, eventTitle, eventDate, eventStartTime, eventDuration, eventGroup);
    return new RedirectView("/stickers/edit/" + id ); 
  }

  @PostMapping
  public RedirectView createNewSticker(
      Authentication auth, 
      String eventTitle,
      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate eventDate,
      @DateTimeFormat(pattern = "HH:mm") LocalTime eventStartTime,
      int eventDuration,
      Long eventGroup
    ) {
    stickerService.createNewSticker(auth.getName(), eventTitle, eventDate, eventStartTime, eventDuration, eventGroup);       
    return new RedirectView("/stickers" + "?month=" + eventDate.getMonthValue());            
  }
  
}
