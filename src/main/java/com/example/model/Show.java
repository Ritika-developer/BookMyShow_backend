//package com.example.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "shows")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Show {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "movie_id")
//    private Movie movie;
//
//    @ManyToOne
//    @JoinColumn(name = "theatre_id")
//    private Theatre theatre;
//
//    private String screen;
//    private String showDate;
//    private String showTime;
//    private Double ticketPrice;
//    private Integer availableSeats;
//}





package com.example.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "shows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "show_date")
    private String showDate;

    @Column(name = "show_time")
    private String showTime;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Theatre theatre;

    @Column(name = "available_seats")
    private Integer availableSeats;

    private String screen;

    @Column(name = "ticket_price")
    private Double ticketPrice;
}


