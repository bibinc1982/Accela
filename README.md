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

I have added hal browser. So the calls can be done through that or postman
The hal [url](http://localhost:8080/browser/index.html#/)

The data has been store in [H2]( http://localhost:8080/h2/login.jsp)
JDBC url is jdbc:h2:mem:accela and username sa.

In this work Person and Address are linked. One Person can have more that one address. So I have used One to many mappling relation. As address can't exist with out person i have created the person table accouring to that.

For unit testing I have used Mockito.I have added it only for PersonServiceImplTest.The intension for me is to explaing my coding style.For real tim work I always recomend 80 percent test coverage.
