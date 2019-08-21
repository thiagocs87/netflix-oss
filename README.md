# CLICKBUS
Test for backend developer position

## Tools used in this project:
* Spring Boot - I chose to be a very widespread tool in the market and because I saw that it is used in Clickbus
* Spring Tool Suite 4 - Used by the ease of developing spring boot applications
* Maven - It's the tool I'm most used to use.
* Lombok - I used to make the code more concise.
* Docker and Docker Compose - I used containers because it was a requirement in the test and also to make it easier for the evaluator to test without having to install tools on the local machine.
* Mysql - The job description said that is the most used database in Clickbus and because of that I made the choice for it.
* FLYWAY - Even though it's a simple structure I used it to create the database structure. Personally I don't like to let Hibernate do this work even in development environment.
* Swagger - It was used to document the API and also to provide to the evaluator a simple way to test all applications functionalities.

## How to run the app
* To run the application just run the app.sh file from the command line. It will build the project, run the unit tests, start the containers and run the application.
* After app.sh finishes the app will be available at http: // localhost: 8080 / swagger-ui.html. 

## Other Informations
* Developed in Linux environment.
* All the unit tests uses a database created just for tests.
* The application uses the ports 3306 and 8080.
