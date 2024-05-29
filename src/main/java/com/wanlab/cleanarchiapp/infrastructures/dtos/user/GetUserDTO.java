package com.wanlab.cleanarchiapp.infrastructures.dtos.user;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class GetUserDTO {

    private UUID id;

    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
