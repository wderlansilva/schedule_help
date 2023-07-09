package com.schedulehelp.schedule.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "table_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;

    @Column(nullable = false)
    private String city_name;

    private String street_name;

    private Long house_number;

    @Column(nullable = false)
    private String cep_user;

//    @JsonIgnore
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "cd_user", nullable = false)
    private User user;

}
