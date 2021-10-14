# Spring-Swagger-Impl

This repo is the example implementation for springfox-swagger2.  


**Pre-requistes**

Setup [Tomcat](https://tomcat.apache.org/download-90.cgi) to run the server along with Java. Also have maven installed in system

**Steps to execute**

1 - Create user.properties file to be used in pom.xml . Sample file exists as user_proto.properties 

2 - Add tomcat.home variable in properties file

3 - Run mvn clean install 

4 - Start tomcat server - sh catalina.sh run

Server should be up. 

**Try** 

1 - http://localhost:8080/v2/api-docs - For swagger json

2 - http://localhost:8080/swagger-ui.html - For swagger UI


 

****

Go through the controller folder to understand the API structure. Also feel free to try APIs written in controller class once the service is up.  
