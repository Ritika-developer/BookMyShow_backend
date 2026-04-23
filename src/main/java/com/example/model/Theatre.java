package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="theatres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String address;
    private Integer screens;
    private String contact;
}