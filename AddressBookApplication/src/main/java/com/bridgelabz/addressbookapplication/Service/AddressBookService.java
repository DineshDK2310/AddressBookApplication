package com.bridgelabz.addressbookapplication.Service;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.model.AddressBookData;
import com.bridgelabz.addressbookapplication.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<AddressBookData> getContact() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBookData addContact(AddressBookDTO addressBookDTO) {
       AddressBookData addressBookData = AddressBookData.Build(addressBookDTO.getId(), addressBookDTO.getName(), addressBookDTO.getAddress(), addressBookDTO.getCity(), addressBookDTO.getState(), addressBookDTO.getPincode(), addressBookDTO.getMobileNumber(), addressBookDTO.getEmail());
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public AddressBookData updateContact(String name,AddressBookDTO addressBookDTO) {
        List<AddressBookData> addressBookDataList = this.getContact();
        for (AddressBookData addressBookData : addressBookDataList){
            if (addressBookData.getName().equals(name)){
                addressBookData.setId(addressBookDTO.getId());
                addressBookData.setName(addressBookDTO.getName());
                addressBookData.setAddress(addressBookDTO.getAddress());
                addressBookData.setCity(addressBookDTO.getCity());
                addressBookData.setState(addressBookDTO.getState());
                addressBookData.setPincode(addressBookDTO.getPincode());
                addressBookData.setMobileNumber(addressBookDTO.getPincode());
                addressBookData.setEmail(addressBookDTO.getEmail());
                return addressBookRepository.save(addressBookData);
            }
        }
        return null;
    }

    @Override
    public void deleteContact(String name) {
        AddressBookData addressBookData = this.searchContactByName(name);
        addressBookRepository.delete(addressBookData);
    }

    @Override
    public AddressBookData searchContactByName(String name) {
        AddressBookData addressBookData = addressBookRepository.findByName(name);
        return addressBookData ;
    }
}
