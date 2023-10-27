- The admin and visitor need an abstract class User
- There is only one admin with email-admin,password-admin123 as mentioned in the assignment handout
- The admin can view all active/inactive Attractions whereas the visitor only needs to view the active Attractions.
- Newly Registered visitors are neither Basic nor Premium members.
- Premium visitors don't need to purchase any ticket, they can visit any animal,attraction.
- Newly registered as well as basic members need to purchase attraction tickets.
- Premium members cannot purchase basic ticket.
- Basic members can upgrade to premium function
- Deal and discount can be used for one ticket/purchase together.
- To visit Animals you need to be either basic or premium member.
- We need to define objects for eg 2 Animals of each type and Admin etc.
- Each print, comparison, hash method uses object methods from the object class.
- Register and login need to use polymorphism from User class
- We need to submit .zip file of our src code
- The HOME_FOLDER should run the commands
  1. mvn clean
  2. mvn compiler
  3. mvn package