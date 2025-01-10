package org.example.service.mapper;

import org.example.http.request.CreateUserRequest;
import org.example.http.response.CreateUserResponse;
import org.example.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IUserServiceMapper {

    @Mapping(target = "id", ignore = true)
    Users mapCreateUserRequestDTOtoUsers(CreateUserRequest createUserRequest);

    CreateUserResponse mapUsersToCreateUserResponseDTO(Users users);
}
