package com.food.user.userService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER_TABLE")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long id;

    private String firstName;

    private String lastName;

    @Column(name = "UserName")
    private String userName;

    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "MobileNumber")
    private Long phoneNumber;

    @Column(name = "UserAge")
    private Integer age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "UserID"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roles = new ArrayList<>();
}
