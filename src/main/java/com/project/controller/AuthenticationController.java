package com.project.controller;

import com.project.payload.request.LoginRequest;
import com.project.payload.response.AuthResponse;
import com.project.payload.response.UserResponse;
import com.project.service.AuthenticationService;
import com.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    private final AuthenticationService authenticationService;

    @PostMapping("/login") // http://localhost:8080/auth/login  + POST + JSON
    public ResponseEntity<AuthResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){

        return authenticationService.authenticateUser(loginRequest);
    }

    @GetMapping("/user") // http://localhost:8080/auth/user  + GET
    public ResponseEntity<UserResponse> findByUserName(HttpServletRequest request){
        String username = (String) request.getAttribute("username");
        UserResponse userResponse = authenticationService.findByUserName(username);

        return ResponseEntity.ok(userResponse);


    }




}
