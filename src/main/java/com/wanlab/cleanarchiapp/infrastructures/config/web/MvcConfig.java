package com.wanlab.cleanarchiapp.infrastructures.config.web;


import com.wanlab.cleanarchiapp.domain.port.UserRepositoryPort;
import com.wanlab.cleanarchiapp.domain.usecases.user.CreateUserUseCase;
import com.wanlab.cleanarchiapp.domain.usecases.user.GetAllUserUseCase;
import com.wanlab.cleanarchiapp.domain.usecases.user.GetUserUseCase;
import com.wanlab.cleanarchiapp.domain.usecases.user.UpdateUserUseCase;
import com.wanlab.cleanarchiapp.infrastructures.repositories.UserRepository;
import com.wanlab.cleanarchiapp.infrastructures.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository){
        UserRepositoryPort userRepositoryPort = new UserServiceImpl(userRepository);
        return new CreateUserUseCase(userRepositoryPort);
    }

    @Bean
    public GetAllUserUseCase getAllUserUseCase(UserRepository userRepository){
        UserRepositoryPort userRepositoryPort = new UserServiceImpl(userRepository);
        return new GetAllUserUseCase(userRepositoryPort);
    }

    @Bean
    public GetUserUseCase getUserUseCase(UserRepository userRepository){
        UserRepositoryPort userRepositoryPort = new UserServiceImpl(userRepository);
        return new GetUserUseCase(userRepositoryPort);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase(UserRepository userRepository){
        UserRepositoryPort userRepositoryPort = new UserServiceImpl(userRepository);
        return new UpdateUserUseCase(userRepositoryPort);
    }
}
