DROP TABLE IF EXISTS PERSON;
DROP TABLE IF EXISTS ADDRESS;

CREATE TABLE PERSON
(   id              INT AUTO_INCREMENT PRIMARY KEY,
    first_name          VARCHAR(25)  NOT NULL,
    second_name         VARCHAR(30)  NOT NULL
);

CREATE TABLE ADDRESS
(   id              INT AUTO_INCREMENT PRIMARY KEY,
    street        VARCHAR(100)  NOT NULL,
    city         VARCHAR(100)  NOT NULL,
    state         VARCHAR(100)  NOT NULL ,
    postCode         NUMBER NOT NULL,
    person_id         NUMBER NOT NULL ,
    foreign key (person_id) references PERSON(id)
);

