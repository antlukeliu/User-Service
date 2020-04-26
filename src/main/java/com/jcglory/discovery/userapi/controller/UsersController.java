package com.jcglory.discovery.userapi.controller;

import com.jcglory.discovery.userapi.dto.UserDto;
import com.jcglory.discovery.userapi.model.CreateUserRequest;
import com.jcglory.discovery.userapi.model.CreateUserResponse;
import com.jcglory.discovery.userapi.service.UsersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("status/check")
    public String status() {
        return "Working";
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE }
            )
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest userRequest) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(userRequest, UserDto.class);
        UserDto createdDto = usersService.createUser(userDto);

        CreateUserResponse response = modelMapper.map(createdDto, CreateUserResponse.class);

        return new ResponseEntity(response,HttpStatus.CREATED);
    }
}
