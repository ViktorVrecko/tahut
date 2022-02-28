package tech.makers.tahut.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "stickers")
public class Sticker {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String content;
  private String fkAuthor;
  private Long fkGroupId;
  

  private int duration;
  @Column(name="event_date", columnDefinition = "TIMESTAMP")
  private LocalDateTime eventDate;
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Sticker other = (Sticker) obj;
    if (content == null) {
      if (other.content != null)
        return false;
    } else if (!content.equals(other.content))
      return false;
    if (duration != other.duration)
      return false;
    if (eventDate == null) {
      if (other.eventDate != null)
        return false;
    } else if (!eventDate.equals(other.eventDate))
      return false;
    if (fkAuthor == null) {
      if (other.fkAuthor != null)
        return false;
    } else if (!fkAuthor.equals(other.fkAuthor))
      return false;
    return true;
  }
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getFkAuthor() {
    return fkAuthor;
  }
  public void setFkAuthor(String fkAuthor) {
    this.fkAuthor = fkAuthor;
  }
  public int getDuration() {
    return duration;
  }
  public void setDuration(int duration) {
    this.duration = duration;
  }
  public LocalDateTime getEventDate() {
    return eventDate;
  }
  public void setEventDate(LocalDateTime eventDate) {
    this.eventDate = eventDate;
  }
  public Long getFkGroupId() {
    return fkGroupId;
  }
  public void setFkGroupId(Long fkGroupId) {
    this.fkGroupId = fkGroupId;
  }

}