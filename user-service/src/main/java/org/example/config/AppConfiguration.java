package org.example.config;

import org.example.clients.ICatalogapi;
import org.example.repository.IUserRepository;
import org.example.service.IUserService;
import org.example.service.impl.UserServiceImpl;
import org.example.service.mapper.IUserServiceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public IUserService userService(IUserRepository userRepository, IUserServiceMapper userServiceMapper, ICatalogapi catalogapi){
        return new UserServiceImpl(userRepository, userServiceMapper, catalogapi);
    }
}
