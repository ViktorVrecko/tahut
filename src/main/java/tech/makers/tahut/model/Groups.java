package tech.makers.tahut.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GROUPS")
public class Groups {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String groupname;
  private Long groupowner;

  @ManyToMany
  @JoinTable(
    name="groups_users",
    joinColumns = @JoinColumn(name = "groups_id"),
    inverseJoinColumns = @JoinColumn(name = "users_id")
  )
  Set<User> members = new HashSet<>();
  
  public String getGroupname() { return groupname; }
  public void setGroupname(String groupname) { this.groupname = groupname; }
  public Long getGroupowner() { return groupowner; }
  public void setGroupowner(Long groupowner) { this.groupowner = groupowner; }

  public void registerUser(User newUser) {
    members.add(newUser);
  }

  public void removeUser(User removeUser) {
    members.remove(removeUser);
  }

  public Long getId() {
    return this.id;
  }

  public Set<User> getMembers() {
    return members;
  }

}
