package com.github.jbreno.ead.authuser.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.jbreno.ead.authuser.dto.UserDto;
import com.github.jbreno.ead.authuser.enums.UserStatus;
import com.github.jbreno.ead.authuser.enums.UserType;
import com.github.jbreno.ead.authuser.models.UserModel;
import com.github.jbreno.ead.authuser.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping(path = "/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PutMapping("/singup")
    public ResponseEntity<Object> registerUser(
            @RequestBody
            @Validated(UserDto.UserView.RegistrationPost.class)
            @JsonView(UserDto.UserView.RegistrationPost.class)
            UserDto userDto) {
        if(userService.existsByUsername(userDto.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Username is Already Taken!");
        }

        if(userService.existsByEmail(userDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Email is Already Taken!");
        }
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        userModel.setUserStatus(UserStatus.ACTIVE);
        userModel.setUserType(UserType.STUDENT);
        userModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        userModel.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        userService.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
    }
}
