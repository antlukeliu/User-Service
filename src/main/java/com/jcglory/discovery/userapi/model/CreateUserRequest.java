package com.jcglory.discovery.userapi.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateUserRequest {

    @NotNull(message="First name cannot be null")
    @Size(min=2, message="First name must not be less than two characters")
    private String firstName;

    @NotNull(message="Last name cannot be null")
    @Size(min=2, message="Last name must not be less than two characters")
    private String lastName;

    @NotNull(message="password cannot be null")
    @Size(min=8, message="Password must be 8 or more characters")
    private String password;

    @NotNull(message="Email cannot be null")
    @Email
    private String email;
}
