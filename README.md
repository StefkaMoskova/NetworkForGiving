# Network for Giving
# VMware TalentBoost 2020 Final project 

'Network for Giving' is a system to keep track of charities. The project has a charities resource, which stores charity objects. 
The project provides basic types of functionality. It is able to Create, Read, Update, and Delete resources (CRUD web application). To make this system usable, there are clear mechanisms for completing the following operations:

    - Create — This consists of a function which is called when a new charity is being added to the catalogue. The program calling the function supplies the values for “title”, “image”, “decription”, “required amount” and “collected amount”.      

    - Read — This consists of a function which is called to see all of the charities currently in the catalogue. There is also a function which represents details for a single charity. 

    - Update (Edit) — This consists of a function which is called when information about a charity must be updated/edited. The program calling the function supplies the new values for “title”, “image”, “decription”, “required amount” and “collected amount”. 

    - Delete — This consists of a function which is called to remove a charity from the catalogue. After this function is called, the charities resource should contain all of the charities it had before, except for the one just deleted.
    
    - Search - Angular Filter search is a component that enables the process of finding charity in the Charity Catalogue by title.

    - *Donate - This consists of a function which is called to donate an amount of money to a charity from the catalogue. After this function is called, the following charity should contain the updated donation amount.
    
    - *FileUpload option - upload option (a photo for a given charity). 

Security is provided by using a JWT token for completing the authentication:

    - JWT token - There are two types of users - registered/unregistered (with/without token). Once the user is logged in, each subsequent request will include the JWT, allowing the user to access routes, services, and resources related to the charities that are permitted with that token. 

Used technologies: Angular CLI version 9.1.6; Spring Boot 1.8; PostgreSQL database

