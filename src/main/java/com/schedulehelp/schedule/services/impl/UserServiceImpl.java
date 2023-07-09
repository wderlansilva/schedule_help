package com.schedulehelp.schedule.services.impl;

import com.schedulehelp.schedule.dto.UserDto;
import com.schedulehelp.schedule.forms.UserForm;
import com.schedulehelp.schedule.models.Address;
import com.schedulehelp.schedule.models.User;
import com.schedulehelp.schedule.repositories.AddressRepository;
import com.schedulehelp.schedule.repositories.UserRepository;
import com.schedulehelp.schedule.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AddressServiceImpl addressService;
    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository, AddressServiceImpl addressService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public ResponseEntity<Object> createUser(UserForm userRequest) {

//        Todo: change this routine
        if (_verifyUser(userRequest)) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Usuário já cadastrado!");
        }

        List<Address> address = userRequest.getAddress();
        User user = this.userRepository.save(userRequest.toConvert());
        address.get(0).setUser(user);

        this.addressService.createAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDto(user));
    }

    private Boolean _verifyUser(UserForm userRequest) {
        Optional<User> user = this.userRepository.
                findByEmail(userRequest.getEmail());

        return user.isPresent();
    }
}
