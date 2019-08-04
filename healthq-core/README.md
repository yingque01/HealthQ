# healthq-core
This is the core part of the platform transformation project for RentBetter and consists mainly of backend DAO and service logic code.

We can choose to have a real local MySQL instance in the PC and following these steps and in accordance with /src/main/resources/db/PropertyPublisherDB.sql
1. Mysql installed
2. the right database schema created
3. the right user and password created, e.g., test/test

IDE: eclipse, version used being Luna or Latest but can support IDEA (IntelliJ)
Spring MVC/boot as the base integration framework, version used being the latest one 
DAO : no ORM as I have switched to spring jdbctemplate instead of springJPA or hibernate 
Restful: I use spring resttemplate but others like Jersey I have used prior too 
swagger will be used to self documenting our API and form basis of our IO page 
Testing TDD and I use in memory MySQL 5.7.19
Real Database is MySQL 8 (but due to test cases avoid using features not supported beyond 5.7.19) but we are open to PostGresSql or mariaDB we can explore mongoDB for front end temp caching 