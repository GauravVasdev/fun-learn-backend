package org.example.http.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.constant.UserServiceConstants;
import org.example.http.request.CreateUserRequest;
import org.example.http.response.CreateUserResponse;
import org.example.http.response.GetUserByIdResponse;
import org.example.http.response.custom.GetAllOrderResponse;
import org.example.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(UserServiceConstants.USER_BASE_URL)
public class UserApiController {

    private final IUserService userService;

    public UserApiController(IUserService userService) {
        this.userService = userService;
    }


    @PostMapping(UserServiceConstants.CREATE_USER)
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest){
        CreateUserResponse createUserResponse = userService.createUser(createUserRequest);
        return new ResponseEntity<>(createUserResponse, HttpStatus.CREATED);
    }

    @GetMapping(UserServiceConstants.GET_USER_BY_ID)
    public ResponseEntity<GetUserByIdResponse> getUserById(@PathVariable Integer userId){
        GetUserByIdResponse user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}

