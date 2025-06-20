package com.github.jbreno.ead.course.dtos;

import com.github.jbreno.ead.course.enums.UserStatus;
import com.github.jbreno.ead.course.enums.UserType;
import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {

    private UUID userId;
    private String username;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String cpf;
    private String imageUrl;
    private UserStatus userStatus;
    private UserType userType;
}
