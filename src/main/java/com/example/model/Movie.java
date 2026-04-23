package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private String language;
    private String duration;
    private String rating;
    @Column(name = "poster_url")
    private String posterUrl;
    private String city;
}