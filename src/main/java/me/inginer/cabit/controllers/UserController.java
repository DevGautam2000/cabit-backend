package me.inginer.cabit.controllers;

import me.inginer.cabit.entities.Ride;
import me.inginer.cabit.entities.User;
import me.inginer.cabit.keys.Keys;
import me.inginer.cabit.services.RideService;
import me.inginer.cabit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RideService rideService;

    @PostMapping(Keys.Routes.SIGNUP)
    public String register(@RequestBody User user) {

        User exUser = userService.getUser(user.getEmail());
        if (exUser == null) {
            userService.saveUser(user);
            return "User created successfully";
        }

        return "User already exists.";
    }

    @PostMapping(Keys.Routes.SIGNIN)
    public Object login(@RequestBody User user) {
        User exUser = userService.getUser(user.getEmail());
        if (exUser != null) {
            if (exUser.getPassword().equals(user.getPassword()))
                return exUser;
            return "Incorrect Password";
        }
        return "User does not exists.";
    }

    @PostMapping(Keys.Routes.GET_CABS)
    public List<Ride> getRides(@RequestBody User user) {

        User exUser = userService.getByUserId(user.getUserId());
        if (exUser != null && exUser.getPassword().equals(user.getPassword()))
            return userService.getUserRide(user.getUserId());

        return new ArrayList<>();
    }


}
