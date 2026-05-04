package com.fitness.plus.repositories;


import com.fitness.plus.model.Gyms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GymRepository extends JpaRepository<Gyms,Long> {

    @Query("SELECT g FROM Gyms g WHERE g.isDeleted = 0 AND g.status = 'ACTIVE'")
    List<Gyms> findActiveGyms();


    boolean existsByEmail(String email);

    boolean existsByGymName(String gymName);


}
