package com.github.jbreno.ead.authuser.controllers;

import com.github.jbreno.ead.authuser.clients.CourseClient;
import com.github.jbreno.ead.authuser.dto.CourseDto;
import com.github.jbreno.ead.authuser.dto.UserCourseDto;
import com.github.jbreno.ead.authuser.models.UserCourseModel;
import com.github.jbreno.ead.authuser.models.UserModel;
import com.github.jbreno.ead.authuser.services.UserCourseService;
import com.github.jbreno.ead.authuser.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserCourseController {

    @Autowired
    private UserCourseService userCourseService;

    @Autowired
    private CourseClient userClient;

    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}/courses")
    public ResponseEntity<Page<CourseDto>> getAllCoursesByUser(
            @PageableDefault(page = 0, size = 10, sort = "courseId", direction = Sort.Direction.ASC)
            Pageable pageable,
            @PathVariable("userId") UUID userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userClient.getAllCourseByUser(userId, pageable));
    }

    @PostMapping("/users/{userId}/courses/subscription")
    public ResponseEntity<Object> saveSubscriptionUserInCourse(
            @PathVariable("userId") UUID userId,
            @RequestBody @Valid UserCourseDto userCourseDto
    ) {
        Optional<UserModel> userModelOptional = userService.findById(userId);
        if(!userModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        if(userCourseService.existsByUserAndCourseId(userModelOptional.get(), userCourseDto.getCourseId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Subscription already exists");
        }
        UserCourseModel userCourseModel = userCourseService.save(userModelOptional.get().convertToUserCourseModel(userCourseDto.getCourseId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(userCourseModel);
    }
}
