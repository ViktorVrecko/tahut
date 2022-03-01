package tech.makers.tahut.service;

import java.util.List;
import java.util.Set;

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
    User searchuser = userRepository.findByUsername(groupowner);
    Groups newGroup = new Groups();
    newGroup.setGroupname(groupname);
    newGroup.setGroupowner(searchuser.getId());
    newGroup.addUserToGroup(searchuser);    

    return groupsRepository.save(newGroup);
  }

  public List<Groups> getGroupsByGroupowner(String groupownername) {
    User searchuser = userRepository.findByUsername(groupownername);
    return groupsRepository.findGroupsByGroupowner(searchuser.getId());
  }

  public Set<Groups> getMembershipsByUsername(String userName) {
    User searchUser = userRepository.findByUsername(userName);
    return searchUser.getGroupMemberships();
  }

  public Set<Groups> getAllUsers(String userName) {
    User searchUser = userRepository.findByUsername(userName);
    return searchUser.getGroupMemberships();
  }
  public boolean isUserInGroup(String userName, Long groupId) {
    User user = userRepository.findByUsername(userName);
    Groups group = groupsRepository.findById(groupId).get();

    return group.getMembers().contains(user);                    
  }

}
