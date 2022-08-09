package com.jihwi.security.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class User {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String password;


}