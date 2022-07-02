package me.inginer.cabit.services;

import me.inginer.cabit.entities.AvailableRide;
import me.inginer.cabit.repositories.AvailableRideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableRideService {

    @Autowired
    AvailableRideRepo availableRideRepo;

    public List<AvailableRide> getRides() {
        return availableRideRepo.findAll();
    }

    public void addRide(AvailableRide availableRide) {
        availableRideRepo.save(availableRide);
    }

    public void addRides(List<AvailableRide> availableRides) {
        availableRideRepo.saveAll(availableRides);
    }

    public Object deleteRide(int rid) {
        try {
            availableRideRepo.deleteById(rid);
        } catch (Exception e) {
            return new ResponseEntity<>("Ride with id " + rid + " does not exist.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Deleted ride with id: " + rid + ". ", HttpStatus.OK);
    }

    public void deleteRides() {
        availableRideRepo.deleteAll();
    }

    public Object modifyAvailableSeats(int rid, String operation, int bookedSeats) {

        AvailableRide exAR = availableRideRepo.findById(rid).orElse(null);
        if (exAR != null) {
            switch (operation) {
                case "ADD":
                    exAR.setAvailableSeats(exAR.getAvailableSeats() < exAR.getTotalSeats() ? exAR.getAvailableSeats() + bookedSeats : exAR.getTotalSeats());
                    break;
                case "DIFF":
                    exAR.setAvailableSeats(exAR.getAvailableSeats() > 0 ? exAR.getAvailableSeats() - bookedSeats : 0);
                    break;
            }
            availableRideRepo.save(exAR);
            return new ResponseEntity<>("Ride updated", HttpStatus.OK);
        }

        return new ResponseEntity<>("Ride does not exist.", HttpStatus.BAD_REQUEST);
    }
}
