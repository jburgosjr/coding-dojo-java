# Coding Dojo Java
### Learning and using Java with Spring to create full sclae web applications

#### Main concepts were:
* ##### Strong and Static Typing
* ##### Understanding a compiled language
* ##### Java OOP
* ##### Java API's


# Projects

#### User Information
  > Create a home servlet class
  > Allow users to pass parameter. if a parameter is not given, have it default to "unknown".
  
  >- implementing servlets
  >- implementing query parameters
  
#### Checkerboard
  > Allow the user to pass the height and width via query parameters and draw a checkerboard accordingly.
  > Have your JSP handle the query parameters directly. You do not need to create a servlet.
  > Use an external CSS file. Do not use inline or internal styling.
  > Check the values of the query parameters inside of your JSP file.
  
  >- Implementing JSPs
  >- Implement static files 
  
#### Pets
  > Create an animal model containing the name, breed, and weight fields.
  > Create a pet interface containing the String showAffection() signature.
  > Extend the animal model and implement the pet interface with both cat and dog models.
  > For the dog implementation of showAffection have different outputs depending on weight.
  > Submit forms to two different routes. Process using two servlets and serve using two JSPs.
  > Use the JSTL to render pages.
  
  >- Put MVC to practice. Modularize your application to have models, views, and controllers.
  >- Implement JSTL tags.
  >- Allow your controller to receive query parameters.

#### Button Clicker
  > Create a Counter servlet that will render a JSP with the information from the wireframe.
  > Use Session to keep track of how many times a user clicks on your page.
  
  >- Implement servlets with session
  
#### Great Number Game
  > Generate a new number on first-time visits or after the game has ended.
  > Retain the value of the number across incorrect guesses while providing feedback to the user.
  > Only reset the number when the player asks to play again.
  > Allow the user to select the range of numbers they want to guess in.
  > Give a fixed number of attempts and inform the user of what attempt they are on; after the user has attempted guessing too many times, give them a message informing them they have lost and tell them the answer; allow them to play again.
  
  >- Implementing post and session together with servlets
  
#### Routing
  > Create a controller named 'CodingController'. For the first 3 routes, use the @RequestMapping annotation.    
  > Have an http GET request to 'localhost:8080/coding' display a text that says 'Hello Coding Dojo!'.  
  > Have an http GET request to 'localhost:8080/coding/python' display a text that says 'Python/Django was awesome!'.  
  > Have an http GET request to 'localhost:8080/coding/java' display a text that says 'Java/Spring is better!'.  
  > Create another controller named 'DojoController'. For the routes below, use the @PathVariable annotation.  
  > Have an http GET request to 'localhost:8080/dojo' display a text that says 'The dojo is awesome!'.  
  > Have an http GET request to 'localhost:8080/burbank-dojo/' display a text that says 'Burbank Dojo is located in Southern California'.  
  > Have an http GET request to 'localhost:8080/san-jose/' display a text that says 'SJ dojo is the headquarters'. 
  
  >- Practice creating a Spring Boot application.
  >- Practice @RestController annotation
  >- Master @RequestMapping.
  
#### Hello Human
  > Create an ap that will render a page with either a default value of "human" or with the name provided in the URL query string.
  
  >- Query Parameters

#### Display Date
  > Use new java.util.Date() in your controller to get the date.  
  > Create an app that will render three pages.  
  > Render one home page as the dashboard with links to the two others.  
  > Render one page at /date with the current date formatted as Saturday, the 22 of January, 2028  
  > Link an external javascript file to the /date template that alerts "This is the date template".  
  > Link an external css file to the /date template that colors the date in blue.  
  > Render one page at /time with the current time formatted as 11:30 PM  
  > Link a external javascript file to the /time template that alerts "This is the time template".  
  > Link a external css file to the /time template that that colors the time in green.  
  
  >- Passing Data
  >- Routing
  >- Time formatting

#### Counter
  >  Create and display a counter on "http://your_server/counter".  
  > Increment the counter on each visit to "http://your_server/".  
  > Counter must start at zero
  > No errors regardless of which page is visited first
  
  >- Practice session
  
#### The Code 
  >  Create a page where a user can submit a code
  > Check the code against the word "bushido"
  > If it's valid, give access to the code route
  > otherwise redirect to root and display a flash error message.
  
  >- Practice Using Error Messages
  
#### Dojo Survey
  > Create a 2 page app that will allow clients to fill out a form and see the form results.
  
  >- Practice POST forms
  
#### Ninja Gold   
  > Create a mini-game that helps a ninja make some money! When you start the game, your ninja should have 0 gold. The ninja can go to different places, farm, cave, house, casino, and earn different amounts of gold. In the case of the casino, your ninja can earn or LOSE up to 50 golds. Your job is to create a web app that allows this ninja to earn gold and to display past activities of this ninja.

  >- more POST form practice
  >- using Redirects
  
#### Languages
  >  create a CRUD application for a computer language dashboard
  
  >- Data Persistence
  >- CRUD
  
#### Lookify
  > Create an app for manipulating playlists
  > Have a dashboard that shows all the songs
  > Be able to delete songs from the dashboard
  > Be able to add new songs on a separate page
  > Be able to search by artist name for songs
  > See top ten songs in database
  > have validations with error messages on song submission.
  
  >- CRUD
  >- Spring Data JPA

#### Licenses 
  > creating an application that will allow users to create licenses for every person.
  > Allow users to create a new person with their first name and last name
  > Allow users to create a license with the state and expiration date; however the license number is done by the server. The first person in the DB has a license number of 000001. Increment by 1 every time a new person is added.
  > Have a person's show page that will retrieve their name, license number, license state, and license expiration date
  
  >- 1:1 relationships
  >- JPA Methods

#### Ninjas & Dojos
  > Allow users to create a new dojo.
  > Allow new ninjas to choose their dojo via a dropdown
  > Have a dojo show page show information of all the ninjas that belong to that specific location.
  
  >- One-To-Many relationships
  >- JPA
  
#### Products and Categories
  > Allow users to create a product.
  > Allow users to create a new category.
  > In the products show page, allow users to add a category to a specific product.
  > In the categories show page, allow users to add a product to a specific category
  
  >- Many-to-Many relationships
  >- JPA methods
  
#### Dojo Overflow   
  > Have the question dashboard display each question and their tags.
  > Allow users to create questions with tags and implement validation errors.
  > Allow users to answer questions and implement validation errors.
  > Have the question show page display all the answers for that specific questions.
  
  >- Relationships
  >- Validations
  >- Domain Models
  >- JPA methods

#### Events
  > Registration and Login with validations
  > Display of events separated by the state to where the event will be held (the first table displays the events under the same state to where the logged user is located; the second displays the events to be held on other states).
  > Update of the Action/Status portion of each event entry.
  > Ability to join an event; cancel the participation to the event or edit/delete event created by the user.
  > Display of attendees per event and discussion board per event.
  > Edit event available only to the creator of the event
  > Logout feature

