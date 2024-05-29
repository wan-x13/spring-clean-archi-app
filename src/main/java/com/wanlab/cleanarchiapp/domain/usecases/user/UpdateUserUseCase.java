package com.wanlab.cleanarchiapp.domain.usecases.user;

import com.wanlab.cleanarchiapp.domain.entities.User;
import com.wanlab.cleanarchiapp.domain.exception.ConflictException;
import com.wanlab.cleanarchiapp.domain.exception.NotFoundException;
import com.wanlab.cleanarchiapp.domain.port.UserRepositoryPort;

import java.util.UUID;

public class UpdateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UpdateUserUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }


    public User execute(UUID id , User user) {
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }
        User user1 = userRepositoryPort.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        if(user.getEmail() != null && !user.getEmail().equals(user1.getEmail())){
            if(userRepositoryPort.findByEmail(user.getEmail()).isPresent()){
                throw new ConflictException("Email already exists");
            }
        }
        if(user.getUsername() != null && !user.getUsername().equals(user1.getUsername())){
            if(userRepositoryPort.findByUsername(user.getUsername()).isPresent()){
                throw new ConflictException("Username already exists");
            }
        }
        if(user.getEmail() != null){
            user1.setEmail(user.getEmail());
        }
        if(user.getUsername() != null){
            user1.setUsername(user.getUsername());
        }
        if(user.getPassword() != null){
            user1.setPassword(user.getPassword());
        }
        return userRepositoryPort.update(id , user1);
    }
}
