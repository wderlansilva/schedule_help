package com.schedulehelp.schedule.dto;

import com.schedulehelp.schedule.models.Address;
import com.schedulehelp.schedule.models.User;
import lombok.Getter;

import java.util.List;

@Getter
public class UserDto {

    private Long cd_user;
    private String nm_user;
    private List<Address> address;

    public UserDto(User user) {
        this.cd_user = user.getCd_user();
        this.nm_user = user.getNm_user();
        this.address = user.getAddress();
    }

}
