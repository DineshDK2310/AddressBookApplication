package com.bridgelabz.addressbookapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor(staticName = "Build")
@NoArgsConstructor
@Entity
public class AddressBookData {
    @Id
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;
    private int pincode;
    private int mobileNumber;
    private String email;
}
