package com.wanlab.cleanarchiapp.domain.usecases.user;

import com.wanlab.cleanarchiapp.domain.entities.User;
import com.wanlab.cleanarchiapp.domain.exception.NotFoundException;
import com.wanlab.cleanarchiapp.domain.port.UserRepositoryPort;

import java.util.UUID;

public class GetUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public GetUserUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }


    public User execute(UUID id) {
        return userRepositoryPort.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}
