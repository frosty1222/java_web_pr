package com.rungroop.web.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.rungroop.web.dto.EventDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="events")
public class Event {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private LocalDateTime startTime;
   private LocalDateTime endTime;
   private String Type;
   @Column(columnDefinition = "text")
   private String photoUrl;
   @CreationTimestamp
   private LocalDateTime createdOn;
   public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDateTime getStartTime() {
	return startTime;
}
public void setStartTime(LocalDateTime startTitme) {
	this.startTime = startTitme;
}
public LocalDateTime getEndTime() {
	return endTime;
}
public void setEndTime(LocalDateTime endTime) {
	this.endTime = endTime;
}
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}
public String getPhotoUrl() {
	return photoUrl;
}
public void setPhotoUrl(String photoUrl) {
	this.photoUrl = photoUrl;
}
public LocalDateTime getCreatedOn() {
	return createdOn;
}
public void setCreatedOn(LocalDateTime createdOn) {
	this.createdOn = createdOn;
}
public LocalDateTime getUpdatedOn() {
	return updatedOn;
}
public void setUpdatedOn(LocalDateTime updatedOn) {
	this.updatedOn = updatedOn;
}
public Club getClub() {
	return club;
}
public void setClub(Club club) {
	this.club = club;
}
   @UpdateTimestamp
   private LocalDateTime updatedOn;
   @ManyToOne
   @JoinColumn(name="club_id",nullable=false)
   private Club club;
   public static Builder builder() {
	   return new Builder();
	}
	public static class Builder {
		 private Long id;
		 private String name;
		 private String photoUrl;
		 private String type;
		 private LocalDateTime startTime;
		 private LocalDateTime endTime;
		 @ManyToOne
		 @JoinColumn(name="club_id",nullable=false)
		 private Club club;
		 public Builder id(Long id) {
		     this.id = id;
		     return this;
		 }

		 public Builder name(String name) {
		     this.name = name;
		     return this;
		 }

		 public Builder photoUrl(String photoUrl) {
		     this.photoUrl = photoUrl;
		     return this;
		 }

		 public Builder type(String type) {
		     this.type = type;
		     return this;
		 }

		 public Builder endTime(LocalDateTime endTime) {
		     this.endTime = endTime;
		     return this;
		 }

		 public Builder startTime(LocalDateTime startTime) {
		     this.startTime = startTime;
		     return this;
		 }
		 
		 public Builder club(Club club) {
				this.club = club;
				return this;
			}
		 public Event build() {
			 Event event = new Event();
			 event.setId(this.id);
			 event.setName(this.name);
			 event.setPhotoUrl(this.photoUrl);
			 event.setType(this.type);
			 event.setEndTime(this.endTime);
			 event.setStartTime(this.startTime);
		     return event;
		      }

	      }
}
