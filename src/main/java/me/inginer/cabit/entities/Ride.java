package me.inginer.cabit.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Ride {

    @Id
    @GeneratedValue
    private int rid;
    private String bookingDate;
    private String cabType;
    private double price;
    private int seats;
    private String srcToDest;
    private int totalSeats;
    private String travelDate;
    private String bookingId = UUID.randomUUID().toString();

    public Ride(int rid, String bookingDate, String cabType, double price, int seats, String srcToDest, int totalSeats, String travelDate) {
        this.rid = rid;
        this.bookingDate = bookingDate;
        this.cabType = cabType;
        this.price = price;
        this.seats = seats;
        this.srcToDest = srcToDest;
        this.totalSeats = totalSeats;
        this.travelDate = travelDate;
    }
}
