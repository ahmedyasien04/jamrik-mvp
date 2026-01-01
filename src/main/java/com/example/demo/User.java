package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
//used to remove getter/setter boilerplate
@Data
//for database
@Entity
@Table(name="USERS")
//to create a default constructor(no boilerplate again)
@NoArgsConstructor
public class User {
    //it is the id in the db table
    @Id
    //randomly generated value starting at 1
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable=false,unique=true)
    private String userName;
    @Column(nullable=false,unique=true)
    private String email;
    @Column(nullable=false)
    private String password;
    private String role;
    private String about;

    public User(Long userId, String UserName, String Email, String Password, String Role, String About){
         this.userId = userId;
         userName=UserName;
         email=Email;
         password=Password;
         role=Role;
         about=About;
    }









}
