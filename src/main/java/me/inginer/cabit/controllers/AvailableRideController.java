package me.inginer.cabit.controllers;

import me.inginer.cabit.dtos.SeatUpdateRequest;
import me.inginer.cabit.entities.AvailableRide;
import me.inginer.cabit.keys.Keys;
import me.inginer.cabit.services.AvailableRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AvailableRideController {

    @Autowired
    private AvailableRideService availableRideService;

    @GetMapping(Keys.Routes.GET_ALL_RIDES)
    public List<AvailableRide> getAllRides() {
        return availableRideService.getRides();
    }

    @PutMapping(Keys.Routes.ADD_TO_ALL_RIDES)
    public String addRide(@RequestBody AvailableRide availableRide) {
        availableRideService.addRide(availableRide);
        return "Added new ride.";
    }

    @PutMapping(Keys.Routes.ADD_MULTIPLE_RIDES)
    public String addRide(@RequestBody List<AvailableRide> availableRides) {
        availableRideService.addRides(availableRides);
        return "Added all rides.";
    }

    @PutMapping(Keys.Routes.UPDATE_SEATS)
    public String updateSeats(@RequestBody SeatUpdateRequest seatUpdateRequest) {
        return availableRideService.modifyAvailableSeats(seatUpdateRequest.getRideId(), seatUpdateRequest.getOperation());
    }

    @DeleteMapping(Keys.Routes.DELETE_FROM_ALL_RIDES)
    public String deleteRide(@RequestBody AvailableRide availableRide) {
        return availableRideService.deleteRide(availableRide.getRid());
    }

    @DeleteMapping(Keys.Routes.DELETE_ALL_RIDES)
    public String deleteRides() {
        availableRideService.deleteRides();
        return "Deleted all rides.";
    }
}
