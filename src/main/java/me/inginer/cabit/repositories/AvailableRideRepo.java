package me.inginer.cabit.repositories;

import me.inginer.cabit.entities.AvailableRide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableRideRepo extends JpaRepository<AvailableRide, Integer> {
    
}
