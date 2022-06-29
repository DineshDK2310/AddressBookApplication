package com.bridgelabz.addressbookapplication.controller;


import com.bridgelabz.addressbookapplication.Service.IAddressBookService;
import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbookapp")
public class AddressBookController {
    @Autowired
    private IAddressBookService iAddressBookService;

    @GetMapping("/getcontacts")
    public ResponseEntity<ResponseDTO> getContactList(){
        ResponseDTO responseDTO = new ResponseDTO("Contacts in the Data",iAddressBookService.getContact());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/searchcontactbyname/{name}")
    public ResponseEntity<ResponseDTO> searchContact(@PathVariable ("name")String name){
        ResponseDTO responseDTO = new ResponseDTO("SearchContactByName",iAddressBookService.searchContactByName(name));
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }


    @PostMapping("/createcontact")
    public ResponseEntity<ResponseDTO> createContact(@RequestBody AddressBookDTO addressBookDTO){
       ResponseDTO responseDTO = new ResponseDTO("Contact Added Successfully",iAddressBookService.addContact(addressBookDTO));
       return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/updatecontact/{name}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable ("name")String name,@RequestBody AddressBookDTO addressBookDTO){
        ResponseDTO responseDTO = new ResponseDTO("Contact Updated Successfully",iAddressBookService.updateContact(name, addressBookDTO));
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/deletecontact/{name}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("name")String name){
        iAddressBookService.deleteContact(name);
        ResponseDTO responseDTO = new ResponseDTO("Contact Deleted Successfully","Deleted Contact is "+name);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
