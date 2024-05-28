package com.wanlab.cleanarchiapp.domain.usecases.user;

import com.wanlab.cleanarchiapp.domain.port.UserRepositoryPort;

public class GetAllUserUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public GetAllUserUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }
}
