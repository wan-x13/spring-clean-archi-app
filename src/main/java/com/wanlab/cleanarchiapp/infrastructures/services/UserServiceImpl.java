package com.wanlab.cleanarchiapp.infrastructures.services;

import com.wanlab.cleanarchiapp.domain.entities.User;
import com.wanlab.cleanarchiapp.domain.port.UserRepositoryPort;
import com.wanlab.cleanarchiapp.infrastructures.models.UserModel;
import com.wanlab.cleanarchiapp.infrastructures.repositories.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserRepositoryPort {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User save(User user) {
        return  userRepository.save(new UserModel(user)).toUser();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(UserModel::toUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserModel::toUser);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id)
                .map(UserModel::toUser);
    }

    @Override
    public void deleteById(UUID id) {
         userRepository.deleteById(id);
    }

    @Override
    public User update(UUID id, User user) {
        return userRepository.save(new UserModel(user)).toUser();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream().map(UserModel::toUser).toList();
    }
}
