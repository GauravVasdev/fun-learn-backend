package org.example.service.impl;

import org.example.http.request.CreateUserRequest;
import org.example.http.response.CreateUserResponse;
import org.example.model.Users;
import org.example.repository.IUserRepository;
import org.example.service.IUserService;
import org.example.service.mapper.IUserServiceMapper;

public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    private final IUserServiceMapper userServiceMapper;

    public UserServiceImpl(IUserRepository userRepository, IUserServiceMapper userServiceMapper) {
        this.userRepository = userRepository;
        this.userServiceMapper = userServiceMapper;
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        Users user = userServiceMapper.mapCreateUserRequestDTOtoUsers(createUserRequest);
        Users createdUser =  userRepository.save(user);
        return userServiceMapper.mapUsersToCreateUserResponseDTO(createdUser);
    }
}
