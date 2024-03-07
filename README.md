# Limit-validation-webservice-

Limit validation webservices
It's a project to maintain limit management among all customer channels.

The project contains 2 stages:

1. Database
 Which include all the entities in our system,in this project My SQL database is used to create 4 classes which are:
    a. Customer class: to store customer details such as id and first name for example.
    b. Global limits class: to store all limits that must apply to all customers for all channels.
    c. Customer limits class: to store the limits for each channel to its customers.
    d. Transaction class : to store all the transactions to all customers 

2.The webservices

To implement the java framework spring boot the intellij is used with postman to test the code.
Because of the architecture is 3 tier architecture it supports the presentation layer (controllers), business logic layer (services), and data access layer (repositories).

First i created the database after that i created the project with the requested  dependencies then i connect the database with the project.

Into the code:
First model package created to connect database tables to the code 
Then Dto package to encapsulate data between the service layer and the controller layer 
Ripo package to get all DB methods to operate in model(entity)
Service package which contains services and other package which is Implementation, in the service the interface only include the method needed and this method will be declare in the implementation class
 The mapper package contains classes to convert from Dto to entity and from entity to Dto 
 The last package is controller package which conrtol the service interface.

 
