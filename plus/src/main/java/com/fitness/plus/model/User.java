package com.fitness.plus.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;

@Entity
@Table(name ="t_users",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    @Size(max = 20)
    @Column(name = "username")
    private String userName;

    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @NotBlank
    @Size(max = 120)
    private Long gymsId;

    @NotBlank
    @Size(max = 30)
    private String Status;


    @Size(max = 5)
    private int emailVerified;

    @NotBlank
    private Date lastLoginAt;

    @NotBlank
    private Date updatedAt;

    @NotBlank
    private Date createdAt;

    @NotBlank
    @Size(max = 120)
    private int updatedBy;

    @NotBlank
    @Size(max = 5)
    private int isDeleted;

    @NotBlank
    @Size(max = 120)
    private String phone;



//
//    public User(String userName, String email, String password) {
//        this.userName = userName;
//        this.email = email;
//        this.password = password;
//    }


    public User(String userName, String email, String password, Long gymsId, String status, int emailVerified, Date lastLoginAt, Date updatedAt, Date createdAt, int updatedBy, int isDeleted, String phone) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.gymsId = gymsId;
        Status = status;
        this.emailVerified = emailVerified;
        this.lastLoginAt = lastLoginAt;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.isDeleted = isDeleted;
        this.phone = phone;
    }

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses = new ArrayList<>();

}
