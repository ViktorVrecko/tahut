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
  private int duration;
  @Column(name="event_date", columnDefinition = "TIMESTAMP")
  private LocalDateTime eventDate;
  
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
}