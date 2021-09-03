package com.interview.accela.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PERSON")

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @Column(name = "first_name")
    String firstName;

    @Column(name = "second_name")
    String secondName;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<Address> address;

    public Person() {
    }

    public Person(String firstName, String secondName, List<Address> address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }


}

