package com.midcel.springboot.service;

import com.midcel.springboot.dto.UserDto;
import com.midcel.springboot.model.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}
