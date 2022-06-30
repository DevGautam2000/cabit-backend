package me.inginer.cabit.services;

import me.inginer.cabit.entities.Ride;
import me.inginer.cabit.repositories.RideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideService {

    @Autowired
    private RideRepo rideRepo;


    public void saveRide(Ride ride) {
        rideRepo.save(ride);
    }

    public String deleteRide(int rid) {
        try {
            rideRepo.deleteById(rid);
        } catch (Exception e) {
            return "Record does not exist.";
        }

        return "Deleted successfully";
    }

}
