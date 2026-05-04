package com.fitness.plus.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GymRequest {

    @NotBlank
    private String gymName;

    @Email
    @NotBlank
    private String gymEmail;

    @NotBlank
    private String city;

    @NotBlank
    private String phoneNumber;

    private Long ownerId;
}
