package tech.makers.tahut.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GROUPS")
public class Groups {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String groupname;
  private Long groupowner;
  
  public Groups(String groupname, Long groupowner) {
    this.groupname = groupname;
    this.groupowner = groupowner;
  }

  public Groups() {
  }

  public String getGroupname() { return groupname; }
  public void setGroupname(String groupname) { this.groupname = groupname; }
  public Long getGroupowner() { return groupowner; }
  public void setGroupowner(Long groupowner) { this.groupowner = groupowner; }
}
