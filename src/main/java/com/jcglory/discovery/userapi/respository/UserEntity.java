package com.jcglory.discovery.userapi.respository;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity
//@Table(name="users")
public class UserEntity implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 181076581262967767L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String firstName;
    @Column(nullable=false, length=50)
    private String lastName;
    @Column(nullable=false, length=120, unique = true)
    private String email;
    @Column(nullable=false, unique = true)
    private String userId;
    @Column(nullable=false, unique = true)
    private String encryptedPassword;
}
