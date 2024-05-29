package com.wanlab.cleanarchiapp.domain.usecases.user;

import com.wanlab.cleanarchiapp.domain.entities.User;
import com.wanlab.cleanarchiapp.domain.port.UserRepositoryPort;

import java.util.List;

public class GetAllUserUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public GetAllUserUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    public List<User> execute() {
        return userRepositoryPort.findAll();
    }
}
