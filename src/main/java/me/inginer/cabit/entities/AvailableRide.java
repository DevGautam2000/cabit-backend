package me.inginer.cabit.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity

public class AvailableRide {

    @Id
    @GeneratedValue
    private int rid;
    private String cabType;
    private double price;
    private int availableSeats;
    private String srcToDest;
    private int totalSeats;
//    @OneToOne(cascade = CascadeType.ALL, targetEntity = Root.class)
//    @JoinColumn(name = "root_details", referencedColumnName = "rid")
//    private Root root;
}
