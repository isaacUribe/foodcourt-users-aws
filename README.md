<br />
<div align="center">
<h3 align="center">Spring Boot FoodCourt Users</h3>
<p>
This is a backend project that is in charge of managing the users of a restaurant chain.
</p>
</div>

### Build With
* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
* ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
* ![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)


## Getting Started

To get a local copy up and running follow these steps.

### Prerequisites
* JDK 17
* Gradle
* MySql

### Instalation

1. Clone The Repo
2. Created a new database in MySQL called foodcourt
3. Update the database connection settings
     ```yml
   # src/main/resources/application.yml   
   spring:
      datasource:
          url: jdbc:mysql://localhost/foodcourt
          username: 
          password: 
   ```
## Usage
1. Open [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)
2. First create an account with the role of admin
3. With the admin account you can create an owner and a restaurant
4. With the owner account you can create an employee account
5. To create a customer account you do not need authentication
6. Don't forget to login with authenticate method and copy the token and paste it in AUTHORIZE