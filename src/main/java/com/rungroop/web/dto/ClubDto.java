package com.rungroop.web.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClubDto {
   private Long id;
   @NotBlank(message="Club title should not be empty")
   private String title;
   @NotEmpty(message="Club link should not be empty")
   private String photoURL;
   @NotBlank(message="Club content should not be empty")
   private String content;
   private LocalDateTime createdOn;
   private LocalDateTime updatedOn;
   private ClubDto() {
       // Private constructor to prevent direct instantiation
   }

   public static Builder builder() {
       return new Builder();
   }

   public LocalDateTime getUpdatedOn() {
	return updatedOn;
}

public void setUpdatedOn(LocalDateTime updatedOn) {
	this.updatedOn = updatedOn;
}

public LocalDateTime getCreatedOn() {
	return createdOn;
}

public void setCreatedOn(LocalDateTime createdOn) {
	this.createdOn = createdOn;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getPhotoURL() {
	return photoURL;
}

public void setPhotoURL(String photoURL) {
	this.photoURL = photoURL;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public static class Builder {
       private Long id;
       private String title;
       private String photoURL;
       private String content;
       private LocalDateTime createdOn;
       private LocalDateTime updatedOn;

       public Builder id(Long id) {
           this.id = id;
           return this;
       }

       public Builder title(String title) {
           this.title = title;
           return this;
       }

       public Builder photoURL(String photoURL) {
           this.photoURL = photoURL;
           return this;
       }

       public Builder content(String content) {
           this.content = content;
           return this;
       }

       public Builder createdOn(LocalDateTime createdOn) {
           this.createdOn = createdOn;
           return this;
       }

       public Builder updatedOn(LocalDateTime updatedOn) {
           this.updatedOn = updatedOn;
           return this;
       }

       public ClubDto build() {
           ClubDto clubDto = new ClubDto();
           clubDto.setId(this.id);
           clubDto.setTitle(this.title);
           clubDto.setPhotoURL(this.photoURL);
           clubDto.setContent(this.content);
           clubDto.setCreatedOn(this.createdOn);
           clubDto.setUpdatedOn(this.updatedOn);
           return clubDto;
       }
   }

}
