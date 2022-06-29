package com.bridgelabz.addressbookapplication.Service;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getContact();

    AddressBookData addContact(AddressBookDTO addressBookDTO);

    AddressBookData updateContact(String name,AddressBookDTO addressBookDTO);

    void deleteContact(String name);

    AddressBookData searchContactByName(String name);

}
