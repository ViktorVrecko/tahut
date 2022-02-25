package tech.makers.tahut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.makers.tahut.model.Groups;
import tech.makers.tahut.model.User;
import tech.makers.tahut.repository.GroupsRepository;
import tech.makers.tahut.repository.UserRepository;

@Service
public class GroupService {

  @Autowired
  GroupsRepository groupsRepository;

  @Autowired 
  UserRepository userRepository;

  public Groups createNewGroup(String groupowner, String groupname) {
    User searchuser = userRepository.findByUsername(groupowner).get(0);
    Groups newGroup = new Groups();
    newGroup.setGroupname(groupname);
    newGroup.setGroupowner(searchuser.getId());
  
    return groupsRepository.save(newGroup);
  }

  public List<Groups> getGroupsByGroupowner(String groupownername) {
    User searchuser = userRepository.findByUsername(groupownername).get(0);
    return groupsRepository.findGroupsByGroupowner(searchuser.getId());
  }
}