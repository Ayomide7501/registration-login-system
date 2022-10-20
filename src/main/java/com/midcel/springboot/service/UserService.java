package com.midcel.springboot.service;

import com.midcel.springboot.dto.UserDto;
import com.midcel.springboot.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
