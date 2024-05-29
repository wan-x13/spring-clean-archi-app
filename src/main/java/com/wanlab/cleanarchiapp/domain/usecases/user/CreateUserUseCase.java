package com.wanlab.cleanarchiapp.domain.usecases.user;

import com.wanlab.cleanarchiapp.domain.entities.User;
import com.wanlab.cleanarchiapp.domain.exception.BadRequestException;
import com.wanlab.cleanarchiapp.domain.exception.ConflictException;
import com.wanlab.cleanarchiapp.domain.port.UserRepositoryPort;

public class CreateUserUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public CreateUserUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }


    public User execute(User user) {
        if(user == null){
            throw new BadRequestException("User cannot be null");
        }
        if(userRepositoryPort.findByUsername(user.getUsername()).isPresent()){
            throw new ConflictException("Username already exists");
        }
        if(userRepositoryPort.findByEmail(user.getEmail()).isPresent()){
            throw new ConflictException("Email already exists");
        }

        return userRepositoryPort.save(user);
    }
}
