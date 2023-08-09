package com.rungroop.web.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="clubs")
public class Club {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String title;
   private String photoURL;
   private String content;
   @CreationTimestamp
   private LocalDateTime createdOn;
   @UpdateTimestamp
   private LocalDateTime updatedOn;
   
   public static Builder builder() {
       return new Builder();
   }
   public String getPhotoURL() {
	    return photoURL;
   }
   public void setPhotoURL(String photoURL) {
       this.photoURL = photoURL;
   }
   public Long getId() {
	    return id;
   }
   public String getTitle() {
	    return title;
   }
   public void setTitle(String title) {
       this.title = title;
   }
   public String getContent() {
	    return content;
   }
   public void setContent(String content) {
       this.content = content;
   }
   public LocalDateTime getCreatedOn() {
	    return createdOn;
   }
   public LocalDateTime getUpdatedOn() {
	    return updatedOn;
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

       public Club build() {
           Club clubDto = new Club();
           clubDto.setId(this.id);
           clubDto.setTitle(this.title);
           clubDto.setPhotoURL(this.photoURL);
           clubDto.setContent(this.content);
           clubDto.setCreatedOn(this.createdOn);
           clubDto.setUpdatedOn(this.updatedOn);
           return clubDto;
       }
   }

public void setId(Long id) {
	this.id = id;
}
public void setUpdatedOn(LocalDateTime updatedOn) {
	this.updatedOn = updatedOn;
}
public void setCreatedOn(LocalDateTime createdOn) {
	this.createdOn = createdOn;
}

}
