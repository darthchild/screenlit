package com.ekagra.screenlit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class Review {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String body;
        private Double rating;

        @ManyToOne
        @JoinColumn(name = "movie_id")
        @JsonIgnore
        private Movie movie;

        public Review(String body) {
            this.body = body;
        }
    }
