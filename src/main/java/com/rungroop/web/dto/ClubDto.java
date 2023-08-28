package com.rungroop.web.dto;

import java.time.LocalDateTime;

import com.rungroop.web.models.UserEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClubDto {
   private Long id;
   @NotBlank(message="Club title should not be empty")
   private String title;
   @NotEmpty(message="Club link should not be empty")
   @Column(columnDefinition = "text")
   private String photoURL;
   @NotBlank(message="Club content should not be empty")
   private String content;
   private LocalDateTime createdOn;
   private LocalDateTime updatedOn;
   private List<EventDto> events;
   private UserEntity createdBy;
}
