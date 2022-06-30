package me.inginer.cabit.services;

import me.inginer.cabit.entities.AvailableRide;
import me.inginer.cabit.repositories.AvailableRideRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    public String deleteRide(int rid) {
        try {
            availableRideRepo.deleteById(rid);
        } catch (Exception e) {
            return "Ride with id " + rid + " does not exist.";
        }

        return "Deleted ride with id: " + rid + ". ";
    }

    public void deleteRides() {
        availableRideRepo.deleteAll();
    }

    public String modifyAvailableSeats(int rid, String operation) {

        AvailableRide exAR = availableRideRepo.findById(rid).orElse(null);
        if (exAR != null) {
            switch (operation) {
                case "ADD":
                    exAR.setAvailableSeats(exAR.getAvailableSeats() < 10 ? exAR.getAvailableSeats() + 1 : 10);
                    break;
                case "DIFF":
                    exAR.setAvailableSeats(exAR.getAvailableSeats() > 0 ? exAR.getAvailableSeats() - 1 : 0);
                    break;
            }
            availableRideRepo.save(exAR);
            return "Ride updated";
        }

        return "Ride does not exist.";
    }
}
