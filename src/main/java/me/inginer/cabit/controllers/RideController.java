package me.inginer.cabit.controllers;


import me.inginer.cabit.entities.Ride;
import me.inginer.cabit.entities.User;
import me.inginer.cabit.keys.Keys;
import me.inginer.cabit.services.RideService;
import me.inginer.cabit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RideController {

    @Autowired
    private RideService rideService;
    @Autowired
    private UserService userService;


    @PutMapping(Keys.Routes.BOOK_CAB)
    public Object addRide(@RequestBody User user) {
        return userService.modifyUserRides(user);
    }

    @PostMapping(Keys.Routes.DELETE_RIDE)
    public Object deleteRide(@RequestBody Ride ride) {
        return rideService.deleteRide(ride.getBookingId());
    }


}
