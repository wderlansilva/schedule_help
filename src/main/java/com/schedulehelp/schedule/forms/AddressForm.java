package com.schedulehelp.schedule.forms;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class AddressForm {

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 100)
    private String city_name;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 300)
    private String street_name;

    private Long house_number;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 15)
    private String cep;

}
