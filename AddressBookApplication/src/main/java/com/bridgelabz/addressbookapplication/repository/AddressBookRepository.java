package com.bridgelabz.addressbookapplication.repository;

import com.bridgelabz.addressbookapplication.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookData, String> {
    AddressBookData findByName(String name);
}
