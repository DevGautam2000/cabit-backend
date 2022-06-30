package me.inginer.cabit.repositories;

import me.inginer.cabit.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepo extends JpaRepository<Ride, Integer> {

}
