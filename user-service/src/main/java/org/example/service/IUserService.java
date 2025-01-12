package org.example.service;

import org.example.http.request.CreateUserRequest;
import org.example.http.response.CreateUserResponse;
import org.example.http.response.custom.GetAllOrderResponse;

import java.util.List;

public interface IUserService {

    CreateUserResponse createUser(CreateUserRequest createUserRequest);

    List<GetAllOrderResponse> getAllOrders();
}
