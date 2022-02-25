package tech.makers.tahut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import tech.makers.tahut.repository.GroupsRepository;
import tech.makers.tahut.service.GroupService;

@Controller
public class GroupsController {

  @Autowired
  GroupsRepository groupsRepository;

  @Autowired
  GroupService groupService;

  @GetMapping("/groups")
  public String groups(Authentication auth, Model model) {   
    model.addAttribute("groups", groupService.getGroupsByGroupowner(auth.getName()));    
    return "/groups/groups";
  }

  @PostMapping("/groups")
  public RedirectView addNewGroup(
    Authentication auth,
    String groupname
  ) {
    groupService.createNewGroup(auth.getName(), groupname);
    return new  RedirectView("/groups");
  }
}
