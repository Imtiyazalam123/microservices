package com.imtiyaj.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rating {

    @Id
    private String id;
    private Integer userId;

    private Integer hotelId;

    private Integer rating;

    private String feedback;

    private Hotel hotel;
}
