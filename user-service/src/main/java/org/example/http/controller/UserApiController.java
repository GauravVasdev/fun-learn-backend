package org.example.http.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.constant.UserServiceConstants;
import org.example.http.request.CreateUserRequest;
import org.example.http.response.CreateUserResponse;
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
@RequestMapping(UserServiceConstants.BASE_URL)
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

    @GetMapping("/get-all-orders")
    @CircuitBreaker(name = "userService", fallbackMethod = "getAllAvailableProducts")
    public ResponseEntity<List<GetAllOrderResponse>> getAllOrders(){
        List<GetAllOrderResponse> orders = userService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    public ResponseEntity<List<GetAllOrderResponse>> getAllAvailableProducts(Exception e){
        List<GetAllOrderResponse> getAllOrderResponses = List.of(
                new GetAllOrderResponse(1, "testName", "testCategroy", "testDescription"));
        return new ResponseEntity<>(getAllOrderResponses, HttpStatus.OK);
    }

    @GetMapping("/home")
    public String getUser(){
        return "Hello";
    }
}

