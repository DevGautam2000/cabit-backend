package me.inginer.cabit.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Ride {

    @Id
    private int rid;
    private String bookingDate;
    private String cabType;
    private double price;
    private int seats;
    private String srcToDest;
    private int totalSeats;
    private String travelDate;

}
