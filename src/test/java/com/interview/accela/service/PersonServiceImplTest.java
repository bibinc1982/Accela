package com.interview.accela.service;

import com.interview.accela.entity.Person;
import com.interview.accela.exception.BadRequestException;
import com.interview.accela.repo.PersonRepo;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceImplTest {
    @Mock
    PersonRepo personRepo;
    @InjectMocks
    PersonServiceImpl personService;
    Person person;
    Person secondPerson;
    Optional<Person> optionalPerson;

    @Before
    public void setUp()  {
        person=new Person();
        person.setId(1L);
        person.setFirstName("Bibin");
        person.setSecondName("Varghese");
        secondPerson=new Person();
        secondPerson.setId(2L);
        secondPerson.setFirstName("Bittu");
        secondPerson.setSecondName("Kuri");
        optionalPerson = Optional.of(person);
    }

    @Test
    public void addPerson() {
        personService.addPerson(person);

        verify(personRepo).saveAndFlush(person);
    }

    @Test
    public void findPerson() throws BadRequestException {
        when(personRepo.findById(1l)).thenReturn(optionalPerson);

        Person result= personService.findPerson(1L);

        assertEquals(person.getId(),result.getId());
        assertEquals(person.getFirstName(),result.getFirstName());
        assertEquals(person.getSecondName(),result.getSecondName());
    }

    @Test(expected = BadRequestException.class)
    public void findPersonException() throws BadRequestException {
        when(personRepo.findById(1l)).thenReturn(Optional.empty());

        personService.findPerson(1L);

    }

    @Test
    public void findAllPerson() {
       when(personRepo.findAll()).thenReturn(Arrays.asList(person,secondPerson));

       List<Person> persons= personService.findAllPerson();

       assertEquals("Bibin",persons.get(0).getFirstName());
       assertEquals("Varghese",persons.get(0).getSecondName());
       assertEquals("Bittu",persons.get(1).getFirstName());
       assertEquals("Kuri",persons.get(1).getSecondName());
    }

    @Test
    public void updatePerson() {
        person.setFirstName("Jeny");
        when(personRepo.findById(1l)).thenReturn(optionalPerson);

        personService.updatePerson(1L,person);

        verify(personRepo).save(person);
    }

}
