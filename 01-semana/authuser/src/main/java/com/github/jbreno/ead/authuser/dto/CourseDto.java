package com.github.jbreno.ead.authuser.dto;

import com.github.jbreno.ead.authuser.enums.CourseLevel;
import com.github.jbreno.ead.authuser.enums.CourseStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class CourseDto {

    private UUID courseId;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private String imageUrl;

    @NotNull
    private CourseStatus courseStatus;

    @NotNull
    private UUID userInstructor;

    @NotNull
    private CourseLevel courseLevel;
}
