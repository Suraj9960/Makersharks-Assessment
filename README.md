# Project Running Steps 
1.  Download Zip File

2.  Run the project as java application

3.  Database Configuration:
    1. Create any database in mysql database
    2. Then change the database configuration in application.properties file
    3. Change database url , username and password

4. For Spring Security:
    1. First create the user using register api.
    2. then login the user with username and password and get token
    3. then by using this token  we can access the secured api.

5. Additional Part:
    . I am also providing the swagger ui for the application.
   . Use this link  http://localhost:8080/swagger-ui/index.html to see api documentation.
   . In that at authorize button past the token which is generated after successfull login.
   . Then we can easily access the securied Api.
