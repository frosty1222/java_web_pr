package com.rungroop.web.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
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

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto{
	   private Long id;
	   @NotNull(message="this field is not allowed to be null")
	   private String name;

	   @DateTimeFormat(pattern="yyy-MM-dd'T'HH:mm")
	   @NotNull(message="this field is not allowed to be null")
	   private LocalDateTime startTime;

	   @DateTimeFormat(pattern="yyy-MM-dd'T'HH:mm")
	   @NotNull(message="this field is not allowed to be null")
	   private LocalDateTime endTime;
	   @NotNull(message="this field is not allowed to be null")
	   private String Type;

	   @Column(columnDefinition = "text")
	   @NotNull(message="this field is not allowed to be null")
	   private String photoUrl;

	   @CreationTimestamp
	   private LocalDateTime createdOn;

	   @UpdateTimestamp
	   private LocalDateTime updatedOn;

	   @ManyToOne
	   @JoinColumn(name="club_id",nullable=false)
	   private Club club;
}

