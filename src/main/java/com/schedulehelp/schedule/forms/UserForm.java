package com.schedulehelp.schedule.forms;

import com.schedulehelp.schedule.models.Address;
import com.schedulehelp.schedule.models.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String name;

    @NotNull
    @NotEmpty
    @Length(min = 6)
    private String password;

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String email;

//    Todo: Verify best typo to attr phone number
    @NotEmpty
    @Length(min = 8, max = 20)
    private String phone_number;

    @NotEmpty
    @NotNull
    private List<Address> address;

    public User toConvert() {
        User user = new User();
        user.setNm_user(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone_number(phone_number);
        user.setAddress(address);

        return user;
    }
}
