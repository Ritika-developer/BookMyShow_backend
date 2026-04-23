//package com.example.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name="seats")
//public class Seat {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String seatNumber;
//
//    private String status;
//
//    @ManyToOne
//    @JoinColumn(name="show_id")
//    private Show show;
//
//    public Seat() {}
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getSeatNumber() {
//        return seatNumber;
//    }
//
//    public void setSeatNumber(String seatNumber) {
//        this.seatNumber = seatNumber;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Show getShow() {
//        return show;
//    }
//
//    public void setShow(Show show) {
//        this.show = show;
//    }
//}











package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_number")
    private String seatNumber;

    private String status;

    @ManyToOne
    @JoinColumn(name = "show_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Show show;
}