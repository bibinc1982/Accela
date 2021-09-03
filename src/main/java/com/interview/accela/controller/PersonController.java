package com.interview.accela.controller;

import com.interview.accela.entity.Person;
import com.interview.accela.exception.BadRequestException;
import com.interview.accela.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "person", consumes = "application/json", produces = "application/json")
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
    final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        LOGGER.info("Adding perons ");
        return new ResponseEntity<>(personService.addPerson(person), HttpStatus.OK);
    }

    @GetMapping(path = "/{person_id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long person_id) {

        Person person;
        try {
            LOGGER.info("Get Person with person id {}", person_id);
            person = personService.findPerson(person_id);
        } catch (BadRequestException e) {
            LOGGER.error("Unable to find Person with person id {}", person_id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping(path = "/count")
    public ResponseEntity<Integer> numberOfPerson() {
        LOGGER.info("Get count of persons person ");
        List<Person> persons = personService.findAllPerson();
        return new ResponseEntity<>(persons.size(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Person>> findAllPerson() {
        LOGGER.info("Get all persons as a list");
        List<Person> persons = personService.findAllPerson();
        if (persons.isEmpty()) {
            LOGGER.info("No persons avaliable");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }


    @PutMapping("{person_id}/update")
    public ResponseEntity<HttpStatus> updatePerson(@PathVariable Long person_id, @RequestBody Person updatedPerson) throws BadRequestException {
        try {
            LOGGER.info("Update Person with person id {}", person_id);
            personService.findPerson(person_id);
        } catch (BadRequestException e) {
            LOGGER.error("unable to update Person with person id {}", person_id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personService.updatePerson(person_id, updatedPerson);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") long id) {
        try {
            LOGGER.info("Deleting Person with person id {}", id);
            personService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            LOGGER.error("Error in deleting Person with person id {}", id);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

