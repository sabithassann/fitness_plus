package com.fitness.plus.services;


import com.fitness.plus.model.Gyms;
import com.fitness.plus.payload.request.GymRequest;
import com.fitness.plus.payload.response.GymDropdownResponse;
import com.fitness.plus.payload.response.GymResponse;
import com.fitness.plus.repositories.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GymService {

    @Autowired
    GymRepository gymRepository;

    public List<GymDropdownResponse> getActiveGymsForDropdown() {

        return gymRepository.findActiveGyms()
                .stream()
                .map(g -> new GymDropdownResponse(g.getGymsId(), g.getGymName()))
                .toList();
    }

    public GymResponse addGym(GymRequest request) {

        if (gymRepository.existsByEmail(request.getGymEmail())) {
            throw new RuntimeException("Gym email already exists");
        }

        if (gymRepository.existsByGymName(request.getGymName())) {
            throw new RuntimeException("Gym name already exists");
        }

        Gyms gym = new Gyms();
        gym.setGymName(request.getGymName());
        gym.setEmail(request.getGymEmail());
        gym.setCity(request.getCity());
        gym.setPhoneNumber(request.getPhoneNumber());
        gym.setOwnerId(request.getOwnerId());

        // system controlled fields
        gym.setStatus("ACTIVE");
        gym.setCratedAt(new Date());
        gym.setUpdatedAt(new Date());
        gym.setIsDeleted(0);

        Gyms saved = gymRepository.save(gym);

        return new GymResponse(
                saved.getGymsId(),
                saved.getGymName(),
                saved.getEmail(),
                saved.getStatus()
        );
    }
}
