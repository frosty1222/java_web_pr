package com.rungroop.web.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.rungroop.web.models.Club;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EventDto{
	   private Long id;
	   private String name;
	   @DateTimeFormat(pattern="yyy-MM-dd'T'HH:mm")
	   private LocalDateTime startTime;
	   @DateTimeFormat(pattern="yyy-MM-dd'T'HH:mm")
	   private LocalDateTime endTime;
	   private String Type;
	   @Column(columnDefinition = "text")
	   private String photoUrl;
	   @CreationTimestamp
	   private LocalDateTime createdOn;
	   @UpdateTimestamp
	   private LocalDateTime updatedOn;
	   @ManyToOne
	   @JoinColumn(name="club_id",nullable=false)
	   private Club club;
   
   public static Builder builder() {
	   return new Builder();
	}
    public Club getClub() {
    	return club;
    }
    public void setClub(Club club) {
    	this.club = club;
    }
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
	public LocalDateTime getStartTitme() {
		return startTime;
	}
	public void setStartTitme(LocalDateTime startTitme) {
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
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public static class Builder {
		 private Long id;
		 private String name;
		 private String photoUrl;
		 private String type;
		 private LocalDateTime startTime;
		 private LocalDateTime endTime;
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

		 public EventDto build() {
			 EventDto eventDto = new EventDto();
			 eventDto.setId(this.id);
			 eventDto.setName(this.name);
			 eventDto.setPhotoUrl(this.photoUrl);
			 eventDto.setType(this.type);
			 eventDto.setEndTime(this.endTime);
			 eventDto.setStartTime(this.startTime);
			 eventDto.setClub(this.club);
		     return eventDto;
		      }

	      }
}

