package me.inginer.cabit.controllers;


import me.inginer.cabit.entities.Ride;
import me.inginer.cabit.entities.User;
import me.inginer.cabit.keys.Keys;
import me.inginer.cabit.services.RideService;
import me.inginer.cabit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RideController {

    @Autowired
    private RideService rideService;
    @Autowired
    private UserService userService;


    @PutMapping(Keys.Routes.BOOK_CAB)
    public String addRide(@RequestBody User user) {
        return userService.modifyUserRides(user);
    }

    @DeleteMapping(Keys.Routes.DELETE_RIDE)
    public String deleteRide(@RequestBody Ride ride) {
        return rideService.deleteRide(ride.getRid());
    }


}
