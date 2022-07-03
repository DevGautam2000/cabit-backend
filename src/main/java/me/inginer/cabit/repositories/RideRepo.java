package me.inginer.cabit.repositories;

import me.inginer.cabit.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface RideRepo extends JpaRepository<Ride, Integer> {

    //    @Query(value = "delete from Ride r where r.booking_id = :bookingId", nativeQuery = true)
    @Transactional
    void deleteByBookingId(String bookingId);
}
