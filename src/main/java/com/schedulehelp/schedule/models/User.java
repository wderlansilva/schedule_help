package com.schedulehelp.schedule.models;

import com.schedulehelp.schedule.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_user;

    @Column(nullable = false)
    private String nm_user;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    private String phone_number;

    @OneToMany(mappedBy = "user")
    private List<Address> address;

    public UserDto toDto(User user) {
        return new UserDto(user);
    }

}
