package me.inginer.cabit.repositories;

import me.inginer.cabit.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, String> {


    @Query(value = "SELECT * from Ride r where r.user_rid = :uid", nativeQuery = true)
    List<Object[]> findByUserId(@Param("uid") String uid);

    User findByEmail(String email);
}
