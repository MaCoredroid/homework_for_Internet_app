### About this homwwork
Use pom.xml to build the marven project with Intellj IDEA

After the spring boot is running, use broswer to visit http://localhost:8080/

### Compute the total area covered by given circles

#### Input format:

x1 y1 r1<br>
x2 y2 r2<br>
in `txt` file <br>
for example: 0 0 4<br>
Denots a circle whose center is (0,0) with radius as 4<br>
Therefore, the `area` of this circle is `16π` <br>

#### About actuator and spring security
To make it easy to investigate my work, I have set the user to "*user*" and password to "*password*". <br>
Just visit http://localhost:8080/actuator/ , and you can see all the available exposed Actuator endpoints.<br>
For example, you can see the health status by visiting http://localhost:8080/actuator/health <br>
Refernece : https://dzone.com/articles/spring-boot-actuator-in-spring-boot-20 <br>
