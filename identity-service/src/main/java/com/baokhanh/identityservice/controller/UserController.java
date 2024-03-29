package com.baokhanh.identityservice.controller;

import com.baokhanh.identityservice.dto.request.ApiResponse;
import com.baokhanh.identityservice.dto.request.UserCreateRequest;
import com.baokhanh.identityservice.dto.request.UserUpdateRequest;
import com.baokhanh.identityservice.entity.User;
import com.baokhanh.identityservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreateRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    @GetMapping
    List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }

}
