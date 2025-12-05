package com.ekagra.screenlit.model;

import jakarta.validation.constraints.NotBlank;

// dto to carry review creation request data
public record ReviewRequestDto(
     @NotBlank(message = "ImdbId cannot be empty!")
     String imdbId,
     String reviewBody,
     Double rating
) {}
