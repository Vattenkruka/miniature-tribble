# The Herokunate - API (Hibernate, Postgres, Spring)

## About the project
 #### An API which can create, read, update and delete actors from a Postgres database using Hibernate.
 #### Uploaded to heruko at https://herokunate.herokuapp.com/ .
 
## Getting started

### Installation

1. Clone the repo
git clone https://https://github.com/Vattenkruka/miniature-tribble.git

2. Open the project in your preferred IDE. I recommend Intellij.

3. To run the project, navigate to the "main" class, right click and "run main".

## Usage
Users can use the web application with the help of the Postman application to test different urls and endpoints. 
By doing so they have easier access to the CRUD functionality of this api.

### Endpoints

Endpoints    | Type         | Description
------------ | ------------ | ------------ 
"https://herokunate.herokuapp.com/actor"          |POST| Adds an actor to the table
"https://herokunate.herokuapp.com/actor/all"       | (GET) | All actors
"https://herokunate.herokuapp.com/actor/{id}"       | (GET) | Gets a specific actor
"https://herokunate.herokuapp.com/actor/{id}"     | (PATCH) | Updates a specific actor's attributes
"https://herokunate.herokuapp.com/actor/{id}"        | (PUT) | Replaces a specific actor's attributes
"https://herokunate.herokuapp.com/actor/{id}"             | (DELETE) | Deletes a specific actor by it's id
"https://herokunate.herokuapp.com/log"                   | (GET)    | The log of actions
  
 
## Author
[Oscar Dahlquist](https://github.com/Vattenkruka)
