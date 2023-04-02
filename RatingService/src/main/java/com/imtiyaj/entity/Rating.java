package com.imtiyaj.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document("user_ratings")
public class Rating {

    @Id
    private String id;
    private Integer userId;

    private Integer hotelId;

    private Integer rating;

    private String feedback;
}
