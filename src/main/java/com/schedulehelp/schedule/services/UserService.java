package com.schedulehelp.schedule.services;

import com.schedulehelp.schedule.dto.UserDto;
import com.schedulehelp.schedule.forms.UserForm;
import com.schedulehelp.schedule.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    ResponseEntity<Object> createUser(UserForm user);
}
