package com.ekagra.screenlit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// To represent the structure of the review request payload

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestDTO {
    private String imdbId;
    private String reviewBody;
    private Double rating;
}
