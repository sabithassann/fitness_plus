package com.fitness.plus.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name ="t_gyms",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "gym_name"),
                @UniqueConstraint(columnNames = "gym_email")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gyms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gymsId;

    @NotBlank
    @Size(max = 20)
    @Column(name = "gym_name")
    private String gymName;

    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "gym_email")
    private String email;

    @NotBlank
    @Size(max = 120)
    private String city;

    @NotBlank
    @Size(max = 120)
    private String phoneNumber;

    @NotBlank
    @Column(name = "userId")
    private Long ownerId;

    @NotBlank
    @Size(max = 10)
    private String status;

    @NotBlank
    private Date cratedAt;

    @NotBlank
    private Date updatedAt;

    @NotBlank
    private int isDeleted;
}
