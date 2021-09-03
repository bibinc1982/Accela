package com.interview.accela.service;

import com.interview.accela.entity.Address;
import com.interview.accela.exception.BadRequestException;

public interface AddressService {

    Address addAddress(Address address);

    Address findAddress(long id) throws BadRequestException;

    void updateAddress(long addressId, Address newAddress);

    void deleteById(long id);
}
