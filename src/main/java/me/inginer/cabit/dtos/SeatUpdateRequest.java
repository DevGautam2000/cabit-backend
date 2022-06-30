package me.inginer.cabit.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class SeatUpdateRequest {

    private int rideId;
    private String operation;
}
