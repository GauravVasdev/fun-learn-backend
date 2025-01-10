package org.example.service;

import org.example.http.request.CreateUserRequest;
import org.example.http.response.CreateUserResponse;

public interface IUserService {

    CreateUserResponse createUser(CreateUserRequest createUserRequest);
}
