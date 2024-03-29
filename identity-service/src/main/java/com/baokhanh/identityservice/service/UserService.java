package com.baokhanh.identityservice.service;

import com.baokhanh.identityservice.dto.request.UserCreateRequest;
import com.baokhanh.identityservice.dto.request.UserUpdateRequest;
import com.baokhanh.identityservice.entity.User;
import com.baokhanh.identityservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreateRequest request){
        User user = new User();

        if (userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("User existed");


        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFistName(request.getFistName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());


        return userRepository.save(user);

    }

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String userId,UserUpdateRequest request){
        User user = getUserById(userId);

        user.setPassword(request.getPassword());
        user.setFistName(request.getFistName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }
}
