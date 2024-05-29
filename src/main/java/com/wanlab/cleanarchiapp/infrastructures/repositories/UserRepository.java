package com.wanlab.cleanarchiapp.infrastructures.repositories;

import com.wanlab.cleanarchiapp.infrastructures.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findByUsername(String username);

    Optional<UserModel> findByEmail(String email);
}
