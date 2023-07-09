package com.schedulehelp.schedule.controllers;

import com.schedulehelp.schedule.dto.UserDto;
import com.schedulehelp.schedule.forms.UserForm;
import com.schedulehelp.schedule.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return this.userService.getUsers()
                .stream().map(user -> new UserDto(user)).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid  UserForm user){
        return this.userService.createUser(user);
    }

}
