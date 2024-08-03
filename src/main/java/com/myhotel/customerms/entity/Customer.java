package com.myhotel.customerms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "customer")
public class Customer {

    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
}
