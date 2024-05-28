package com.wanlab.cleanarchiapp.domain.port;

import com.wanlab.cleanarchiapp.domain.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    User save(User user);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findById(UUID id);

    void deleteById(UUID id);
    User update(UUID id , User user);

    List<User> findAll();

}
