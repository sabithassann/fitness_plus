package com.fitness.plus.payload.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GymDropdownResponse {

    private Long gymsId;
    private String gymName;
}
