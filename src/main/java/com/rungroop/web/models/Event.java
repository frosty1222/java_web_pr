package com.rungroop.web.models;

import java.time.LocalDateTime;

import lombok.*;
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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
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

   @UpdateTimestamp
   private LocalDateTime updatedOn;

   @ManyToOne
   @JoinColumn(name="club_id",nullable=false)
   private Club club;
	public void setClub(Club club) {
	   this.club = club;
	}
}
