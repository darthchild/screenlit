package com.ekagra.screenlit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private String imdbId;
    private String reviewBody;
    private Double rating;
}
