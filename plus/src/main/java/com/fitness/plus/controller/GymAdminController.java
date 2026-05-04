package com.fitness.plus.controller;

import com.fitness.plus.payload.request.GymRequest;
import com.fitness.plus.payload.response.GymDropdownResponse;
import com.fitness.plus.payload.response.GymResponse;
import com.fitness.plus.services.GymService;
import com.fitness.plus.util.RequestUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/gyms")
public class GymAdminController {

    private static final Logger log = LoggerFactory.getLogger(GymAdminController.class);

    @Autowired
    GymService gymService;

    @GetMapping("/dropdown")
    public ResponseEntity<?> getGymDropdown() {

        List<GymDropdownResponse> gyms = gymService.getActiveGymsForDropdown();

        return ResponseEntity.ok(gyms);
    }

    @PostMapping
    public ResponseEntity<?> addGym(
            @Valid @RequestBody GymRequest request,
            HttpServletRequest httpRequest) {

        String ip = RequestUtil.getClientIp(httpRequest);

        log.info("Gym add request from IP: {}", ip);

        GymResponse response = gymService.addGym(request);

        log.info("Gym created successfully with ID: {}", response.getGymsId());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
