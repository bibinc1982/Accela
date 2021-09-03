 ## Accela interview project.
I have used 
 Java 11
Spring boot,
Rest,
JPA,
H2 , 
Maven , 
Mokito ,
slf4j.

Use postman to call the rest services 
The data has been store in [H2]( http://localhost:8080/h2/login.jsp)
JDBC url is jdbc:h2:mem:accela and username sa.

In this work Person and Address are linked. One Person can have more that one address. So I have used One to many mappling relation. As address can't exist with out person i have created the person table accouring to that.

For unit testing I have used Mockito.I have added it only for PersonServiceImplTest.The intension for me is to explaing my coding style.For real tim work I always recomend 80 percent test coverage.

 For adding person localhost:8080/person/add
 >{
   "firstName":"Bibin",
   "secondName":"Varghese"
}

For adding adress localhost:8080/address/{addressid}/add
>{
     "street":"Street Address",
     "city" :"City Address",
     "state": "State Address",
     "postcode": 12345
}
