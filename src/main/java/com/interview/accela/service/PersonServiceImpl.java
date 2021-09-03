package com.interview.accela.service;

import com.interview.accela.entity.Person;
import com.interview.accela.exception.BadRequestException;
import com.interview.accela.repo.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    final PersonRepo personRepo;

    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public Person addPerson(Person person) {
        return personRepo.saveAndFlush(person);
    }

    @Override
    public Person findPerson(long id) throws BadRequestException {
        Optional<Person> personOptional = personRepo.findById(id);
        if (personOptional.isEmpty()) {
            throw new BadRequestException("Unable to find Person with id " + id);
        }
        return personOptional.get();
    }

    @Override
    public List<Person> findAllPerson() {
        return personRepo.findAll();
    }

    @Override
    public void updatePerson(long personId, Person newPerson) {

        personRepo.findById(personId).ifPresent((Person person) -> {
            if (newPerson.getFirstName() != null)
                person.setFirstName(newPerson.getFirstName());
            if (newPerson.getSecondName() != null)
                person.setSecondName(newPerson.getSecondName());
            personRepo.save(person);
        });
    }

    @Override
    public void deleteById(long id) {
        personRepo.findById(id).ifPresent((Person person) -> personRepo.delete(person));
    }

}
