package com.rungroop.web.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.rungroop.web.dto.EventDto;

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
   @Column(columnDefinition = "text")
   private String photoURL;
   private String content;
   @CreationTimestamp
   private LocalDateTime createdOn;
   @UpdateTimestamp
   private LocalDateTime updatedOn;
   @ManyToOne
   @JoinColumn(name = "created_by", nullable = false)
   private UserEntity createdBy;
   @OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE)
   private List<Event> events = new ArrayList<>();
}
