package com.interview.accela.service;

import com.interview.accela.entity.Person;
import com.interview.accela.exception.BadRequestException;

import java.util.List;

public interface PersonService {
    Person addPerson(Person person);

    Person findPerson(long id) throws BadRequestException;

    List<Person> findAllPerson();

    void updatePerson(long personId, Person newPerson) throws BadRequestException;

    void deleteById(long id);
}
