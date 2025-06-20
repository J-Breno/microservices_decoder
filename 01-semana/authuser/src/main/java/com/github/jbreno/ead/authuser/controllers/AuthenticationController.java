package com.github.jbreno.ead.authuser.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.jbreno.ead.authuser.dto.UserDto;
import com.github.jbreno.ead.authuser.enums.UserStatus;
import com.github.jbreno.ead.authuser.enums.UserType;
import com.github.jbreno.ead.authuser.models.UserModel;
import com.github.jbreno.ead.authuser.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Log4j2
@RestController
@RequestMapping(path = "/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {


    @Autowired
    private UserService userService;

    @PostMapping("/singup")
    public ResponseEntity<Object> registerUser(
            @RequestBody
            @Validated(UserDto.UserView.RegistrationPost.class)
            @JsonView(UserDto.UserView.RegistrationPost.class)
            UserDto userDto) {
        log.debug("POST registerUser userDto received {}", userDto.toString());
        if(userService.existsByUsername(userDto.getUsername())) {
            log.warn("Username {} is Already Taken", userDto.getUsername());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Username is Already Taken!");
        }

        if(userService.existsByEmail(userDto.getEmail())) {
            log.warn("Email {} is Already Taken", userDto.getEmail());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Email is Already Taken!");
        }
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        userModel.setUserStatus(UserStatus.ACTIVE);
        userModel.setUserType(UserType.STUDENT);
        userModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        userModel.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        userService.save(userModel);
        log.debug("POST registerUser userId saved {}", userModel.getUserId());
        log.info("User saved successfully userId {}", userModel.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
    }

    @GetMapping("/")
    public  String index() {
        log.trace("TRACE");
        log.debug("DEBUG");
        log.info("INFO");
        log.warn("WARN");
        log.error("ERROR");
        return "Loggin spring boot...";
    }
}
