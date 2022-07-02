package me.inginer.cabit.services;

import me.inginer.cabit.entities.Ride;
import me.inginer.cabit.entities.User;
import me.inginer.cabit.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public void saveUser(User user) {
        userRepo.save(user);
    }

    public User getUser(String email) {
        return userRepo.findByEmail(email);

    }

    public User getByUserId(String userId) {
        return userRepo.findById(userId).orElse(null);

    }

    public Object modifyUserRides(User user) {
        User exUser = userRepo.findById(user.getUserId()).orElse(null);
        if (exUser == null) return new ResponseEntity<>("User does not exist.", HttpStatus.BAD_REQUEST);

        if (!exUser.getPassword().equals(user.getPassword()))
            return new ResponseEntity<>("Incorrect Password.", HttpStatus.BAD_REQUEST);
        exUser.getRides().add(user.getRides().get(0));
        userRepo.save(exUser);

        return new ResponseEntity<>("Ride added successfully", HttpStatus.OK);
    }

    public List<Ride> getUserRide(String uid) {
        List<Object[]> rideObjects = userRepo.findByUserId(uid);
        List<Ride> rides = new ArrayList<>();
        if (!rideObjects.isEmpty()) {
            for (Object[] obj : rideObjects) {
                rides.add(new Ride(
                        Integer.parseInt(obj[0].toString()),
                        obj[1].toString(),
                        obj[2].toString(),
                        Double.parseDouble(obj[3].toString()),
                        Integer.parseInt(obj[4].toString()),
                        obj[5].toString(),
                        Integer.parseInt(obj[6].toString()),
                        obj[7].toString(), obj[9].toString()));
            }
        }
        return rides;
    }
}
