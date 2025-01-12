package org.example.service.impl;

import org.example.clients.ICatalogapi;
import org.example.http.request.CreateUserRequest;
import org.example.http.response.CreateUserResponse;
import org.example.http.response.custom.GetAllOrderResponse;
import org.example.model.Users;
import org.example.repository.IUserRepository;
import org.example.service.IUserService;
import org.example.service.mapper.IUserServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    private final IUserServiceMapper userServiceMapper;

    private final ICatalogapi catalogapi;

    public UserServiceImpl(IUserRepository userRepository, IUserServiceMapper userServiceMapper, ICatalogapi catalogapi) {
        this.userRepository = userRepository;
        this.userServiceMapper = userServiceMapper;
        this.catalogapi = catalogapi;
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        Users user = userServiceMapper.mapCreateUserRequestDTOtoUsers(createUserRequest);
        Users createdUser =  userRepository.save(user);
        return userServiceMapper.mapUsersToCreateUserResponseDTO(createdUser);
    }


    @Override
    public List<GetAllOrderResponse> getAllOrders() {
        return catalogapi.getAllOrders();
    }
}
