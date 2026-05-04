package com.fitness.plus.payload.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GymResponse {
    private Long gymsId;
    private String gymName;
    private String gymEmail;
    private String status;
}
