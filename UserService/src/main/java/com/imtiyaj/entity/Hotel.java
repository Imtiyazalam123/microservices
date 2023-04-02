package com.imtiyaj.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {

	private Integer id;

	private String name;

	private String location;

	private String about;
}
