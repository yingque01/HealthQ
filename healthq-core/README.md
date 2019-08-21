# healthq-core
This is the core part of the platform transformation project for HealthQ and consists mainly of backend DAO and service logic code.

##IDE: 
eclipse, version used being Luna or Latest but can support IDEA (IntelliJ)

##Framework
Spring MVC/boot as the base integration framework, version used being the latest one 

##DAO
DAO : no ORM as I have switched to spring jdbctemplate instead of springJPA or hibernate 

##database ddl
The database schema used by this project is documented here /src/main/resources/db/HealthQDB.sql along with MySQL workbench generated .mwb/pdf/svg files. You can comment in the ddl with --(or# prefer -- as Eclipse shows -- comments in a different colour) comment or /star star/ over multiple lines (remember to put the **space after** -- or /star).

##Test Driven Development: use of real instance vs in-memory instance
1. Using real instance (can be MySQL 8+, but due to in-memory DB supports 5.7.19 as the highest version do not use any features not compatible with 5.7.19):
	* Install a real local MySQL instance of an appropriate version on your PC or point to a remotely hosted dev/test/staging instance.
	* Create the database schema and tables in the real instance.
	* Create a test user and password and assign the privileges for the db schema to the user , e.g.:
		1. CREATE USER IF NOT EXISTS 'test'@'localhost' IDENTIFIED WITH mysql_native_password BY 'test';
		2. grant all privileges on rbwww_utils.* to 'test'@'localhost';
	* this option will be used when /src/test/resources/application-test.properties is configured as follows: 
		1. healthq.datasource.url points to 3306 (assume the local MySQL physical instance is running on port 3306).
		2. healthq.datasource.istouseembeddeddb is set to true.
2. Using an in-memory instance (MySQL 5.7.19):
	* an in-memory MySQL DB will be created and with the defined schema and users accorsing to /src/main/resources/db/HealthQDB.sql.
	* this option will be used when /src/test/resources/application-test.properties is configured as follows: 
		1. healthq.datasource.url points to 3307 (chosen this port to be different to the assumed local physical MySQL instance).
		2. healthq.datasource.istouseembeddeddb is set to true.

At the moment our DB engine is MySQL but we are open to PostGresSql or mariaDB we can explore mongoDB for front end temp caching 




