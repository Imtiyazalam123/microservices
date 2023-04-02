package com.imtiyaj.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "user_seq_gen", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", initialValue = 100)
	private Integer id;
	
	@Column(name = "NAME", length = 20)
	private String name;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ABOUT")
	private String about;

	@Transient
	private List<Rating> ratings;
}
