package com.bridgelabz.addressbookapplication.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDTO {
    @NotNull
    public int id;

    @NotNull
    public String name;

    @NotNull
    public String address;

    @NotNull
    public String city;

    @NotNull
    public String state;

    @NotNull
    public int pincode;

    @NotNull
    public int mobileNumber;

    @NotNull
    public String email;
}
