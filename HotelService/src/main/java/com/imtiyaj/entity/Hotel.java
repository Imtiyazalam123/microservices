package com.imtiyaj.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "HOTEL")
public class Hotel {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "hotel_seq_gen")
	@SequenceGenerator(name = "hotel_seq_gen", sequenceName = "hotel_seq", initialValue = 100)
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "ABOUT")
	private String about;
}
