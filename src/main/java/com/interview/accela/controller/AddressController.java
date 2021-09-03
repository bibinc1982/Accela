package com.interview.accela.controller;


import com.interview.accela.entity.Address;
import com.interview.accela.entity.Person;
import com.interview.accela.exception.BadRequestException;
import com.interview.accela.service.AddressService;
import com.interview.accela.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "address", consumes = "application/json", produces = "application/json")
@Slf4j
public class AddressController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
    final AddressService addressService;
    final PersonService personService;

    public AddressController(AddressService addressService, PersonService personService) {
        this.addressService = addressService;
        this.personService = personService;
    }

    @PostMapping(path = "{person_id}/add")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Address> addAddress(@PathVariable long person_id, @RequestBody Address address) {
        LOGGER.info("Adding Address for the persons {}", person_id);

        Person person;
        try {
            person = personService.findPerson(person_id);
        } catch (BadRequestException e) {
            LOGGER.error("BadRequestException ,unable to find person", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        address.setPerson(person);
        return new ResponseEntity<>(addressService.addAddress(address), HttpStatus.OK);
    }

    @PutMapping("{address_id}/update")
    public ResponseEntity<HttpStatus> updateAddress(@PathVariable long address_id, @RequestBody Address updatedAddress) throws BadRequestException {
        LOGGER.info("Updating Address with address id {}", address_id);

        try {
            addressService.findAddress(address_id);
        } catch (BadRequestException e) {
            LOGGER.error("BadRequestException ,unable to find person", e);

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        addressService.updateAddress(address_id, updatedAddress);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<HttpStatus> deleteAddress(@PathVariable("id") long id) {
        LOGGER.info("Deleting Address with address id {}", id);

        try {
            addressService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            LOGGER.error("Unable to delete address with id {} cause {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
