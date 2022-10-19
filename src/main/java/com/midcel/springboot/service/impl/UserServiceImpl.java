package com.midcel.springboot.service.impl;

import com.midcel.springboot.dto.UserDto;
import com.midcel.springboot.model.Role;
import com.midcel.springboot.model.User;
import com.midcel.springboot.repository.RoleRepository;
import com.midcel.springboot.repository.UserRepository;
import com.midcel.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        //todo: encrypt password using spring security
        user.setPassword(userDto.getPassword());

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);

    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
