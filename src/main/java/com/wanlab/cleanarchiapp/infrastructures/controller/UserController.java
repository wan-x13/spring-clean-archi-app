package com.wanlab.cleanarchiapp.infrastructures.controller;


import com.wanlab.cleanarchiapp.domain.entities.User;
import com.wanlab.cleanarchiapp.domain.usecases.user.CreateUserUseCase;
import com.wanlab.cleanarchiapp.domain.usecases.user.GetAllUserUseCase;
import com.wanlab.cleanarchiapp.domain.usecases.user.GetUserUseCase;
import com.wanlab.cleanarchiapp.domain.usecases.user.UpdateUserUseCase;
import com.wanlab.cleanarchiapp.infrastructures.dtos.user.CreateUserDTO;
import com.wanlab.cleanarchiapp.infrastructures.dtos.user.GetUserDTO;
import com.wanlab.cleanarchiapp.infrastructures.models.UserModel;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private final GetAllUserUseCase getAllUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    private final ModelMapper modelMapper;

    public UserController(GetAllUserUseCase getAllUserUseCase,
                          GetUserUseCase getUserUseCase,
                          CreateUserUseCase createUserUseCase,
                          UpdateUserUseCase updateUserUseCase, ModelMapper modelMapper) {
        this.getAllUserUseCase = getAllUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/api/users")
    public ResponseEntity<GetUserDTO> createUser(@RequestBody  CreateUserDTO createUserDTO) {
        User user = modelMapper.map(createUserDTO, User.class);
        return ResponseEntity.ok().body(modelMapper.map(createUserUseCase.execute(user), GetUserDTO.class));
    }

}
