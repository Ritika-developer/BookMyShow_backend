package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowRequest {
    private Long movieId;
    private Long theatreId;
    private String screen;
    private String showDate;
    private String showTime;
    private Double ticketPrice;
    private Integer availableSeats;
}