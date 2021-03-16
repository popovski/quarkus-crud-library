# Spring Boot CRUD application used for training IWConnect Junior Developers

Sample CRUD project based on Quarkus, RestEasy, Hibernate, Mysql

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Java JDK 8

### Installing

* Get the project from GIT "git clone https://github.com/popovski/quarkus-crud-library"
* Create new Database in Mysql "iw_library"
* Execute the sql scripted placed in "/iw-labs-crud-library-quarkus/src/main/resources/sql/ddl.sql"
* Set datasource url of your MYSQL DB application.properties -> spring.datasource.url
* Set mysql user value into application.properties -> spring.datasource.username
* Set mysql user password value into application.properties -> spring.datasource.password

### Build and Start the project
* go to root directory of the project
* run the project in Development mode
* ./mvnw compile quarkus:dev
* Build and Run for Production
* ./mvnw package
* java -jar target/quarkus-app/quarkus-run.jar

## Running the tests

.\mvnw test - command for running the junit tests

## Built With

* [Spring Boot](https://quarkus.io/guides/getting-started)
* [Maven](https://maven.apache.org/) - Dependency Management
* [MySql](https://www.mysql.com/) 

## Demo

After you start the application the server will listen on port 8060
* Get all books <br />
HTTP GET localhost:8060/books/
* Create new book <br />
HTTP POST localhost:8060/books/ <br />
Payload Json Body <br />
{
   "title": "NEW TITLE",
   "description": "NEW DESCRIPTION"
}
* Update existing book <br />
HTTP PUT localhost:8060/books/<UUID> - comment replace UUID with existing book UUID <br />
Payload Json Body <br />
{
   "title": "UPDATE TITLE",
   "description": "UPDATE DESCRIPTION"
}

* Delete Resource <br />
localhost:8060/api/books/<UUID> - comment replace UUID with existing book UUID <br />

## Authors

* **Nikola Popovski** - *Initial work* - [Repository](https://github.com/popovski)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
