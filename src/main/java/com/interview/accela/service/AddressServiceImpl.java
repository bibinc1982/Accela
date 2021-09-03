package com.interview.accela.service;

import com.interview.accela.entity.Address;
import com.interview.accela.exception.BadRequestException;
import com.interview.accela.repo.AddressRepo;
import com.interview.accela.repo.PersonRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    final AddressRepo addressRepo;
    final PersonRepo personRepo;

    AddressServiceImpl(AddressRepo addressRepo, PersonRepo personRepo) {
        this.addressRepo = addressRepo;
        this.personRepo = personRepo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Address addAddress(Address address) {
        return addressRepo.saveAndFlush(address);
    }

    @Override
    public Address findAddress(long id) throws BadRequestException {

        Optional<Address> optionalAddress = addressRepo.findById(id);
        if (optionalAddress.isEmpty()) {
            throw new BadRequestException("Unable to find Address with id " + id);
        }
        return optionalAddress.get();
    }


    @Override
    public void updateAddress(long addressId, Address newAddress) {

        addressRepo.findById(addressId).ifPresent((Address address) -> {
            if (newAddress.getStreet() != null)
                address.setStreet(newAddress.getStreet());
            if (newAddress.getCity() != null)
                address.setCity(newAddress.getCity());
            if (newAddress.getState() != null)
                address.setState(newAddress.getState());
            if (newAddress.getPostcode() != null)
                address.setPostcode(newAddress.getPostcode());
            addressRepo.save(address);
        });
    }

    @Override
    public void deleteById(long id) {
        addressRepo.findById(id).ifPresent((Address address) -> addressRepo.delete(address));
    }
}
