# Accela interview project.

   ####  This is a sample  Java / Maven / Spring Boot application that is creating as a part of Accela interview process
 
---

### Table of Contents
Sections headers will be used to reference location of destination.

- [Description](#description)
- [How To Use](#how-to-use)
- [References](#references)
- [Author Info](#author-info)

---

## Description

The service is just a simple person and related address review REST service.Each person can have more than one address . Person and address can be deleted or updated. As address can't exist with out person , when person is deleted address linked with the person will also get deleted.  We can view the persons as a list or individually  passing the Id. Address can be viewed  individually or all the address linked to a person.  It uses an in-memory database (H2) to store the data. You can also do with a relational database like MySQL or PostgreSQL. If your database connection properties work, you can call some REST endpoints defined in ```com.interview.accela.controller.AddressController``` and ```com.interview.accela.controller.PersonController```  on **port 8080**. (see below)

#### Technologies
- Java 11
- Spring boot
- Rest
- JPA
- H2 Database
- Maven
- Mokito
- Slf4j


[Back To The Top](#read-me-template)

---

## How To Use

#### Installation
   This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 11 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
```
        java -jar  target/accela-0.0.1-SNAPSHOT.jar
or
        mvn spring-boot:run 
```
* Check the stdout or boot_example.log file to make sure no exceptions are thrown

Once the application runs you should see something like this

```
2021-09-16 14:33:07 - Tomcat started on port(s): 8080 (http) with context path ''
2021-09-16 14:33:07 - Started AccelaApplication in 10.674 seconds (JVM running for 11.764)

```

#### API Reference

Use postman to call the rest services 

### Create a adding person

```
POST /person/add
Accept: application/json
Content-Type: application/json

{
   "firstName":"Bibin",
   "secondName":"Varghese"
}

RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8090/example/v1/hotels/1
```

### Create a adding address


```
POST/address/{addressid}/add
{
     "street":"Street Address",
     "city" :"City Address",
     "state": "State Address",
     "postcode": 12345
}

```
### To view your H2 in-memory datbase

This project runs on H2 in-memory database. To view and query the database you can browse to http://localhost:8080/h2/login.jsp. JDBC url is jdbc:h2:mem:accela . Default username is 'sa' with a blank password. 

[Back To The Top](#read-me-template)

### Get information about system health, configurations, etc.

```
http://localhost:8080/env
http://localhost:8080/actuator/health
http://localhost:8080/info
http://localhost:8080/actuator/metrics
```

---

## References
https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.spring-application
https://www.springboottutorial.com/spring-boot-projects-with-code-examples

[Back To The Top](#read-me-template)


---

## Author Info
     
- Linkedin - [@Bibin Varghese](https://www.linkedin.com/in/bibin-varghese-a22508140/)

[Back To The Top](#read-me-template)
