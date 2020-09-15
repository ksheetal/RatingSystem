# RatingSystem
Assumptions - 
Driver and User have logged in into the app and drive has already been started that is, a drive id is generated for that particular drive.
All Business logic is written is controller instead of service class. 
Each time a user reviews a drive, a separate entry store in the database, specifying whether the user or driver has provided the review.
Aggregate is the average of all the ratings for a particular user/Driver.



Approach - 

User will hit the rating button i.e. hit the backend API with ratingModel Payload. driveID, DriverId, UserID fields will be  auto-filled. Rating and reviews will be taken as an input. payload(ratedBy-User)
Same as 1 for Driver in the payload (ratedBy- driver)
parameter. Also there is a "by" parameter which tells who is giving rating to whom.
To see the aggregated rating of all rides of a user, I am asking User-ID in parameter and based upon that i'll check into the mongo collections to find all the Users with that Id, add all the ratings and divide them by a total number of drives by that user.
Same logic for driver


Schema -
userModel - 
@Id
private String userID;
@NonNull
private String name;
@NonNull
private String email;
@NonNull
private String password;
@NonNull
private String role;
@NonNull
private Date createDate = new Date();


ratingModel - 
@Id
private String driveID;
@NonNull
private String driverID;
@NonNull
private String userID;
@NonNull
private Integer rating;
@NonNull
private String review;
@NonNull
private String By;

 #### Tools/Tech-Stack
 - [Spring Boot/ MongoDB]
 - [Spring Security, Lambok, Mongo, Logger ]
 
 #### How to Run?
Clone this project [link](https://github.com/ksheetal/RatingSystem.git) first.

1) Go to oyeRickshaw project folder.
2) Go to this file oyeRickshaw/src/main/resources/application.properties and fill mongo cred according to your local mongo setup.
3) Type mvn clean then mvn package [make sure you have maven installed into your sytem]
4) Step-3 will create a targert folder, to to this folder and run this command java -jar oyeRickshaw-0.0.1-SNAPSHOT.jar
5) This will run your application on port 8080
6) In browser, open http:://localhost:8080/swagger-ui.com
7) it will prompt a alert then type username as oye123 and password as oye123Api
8) it will open swagger UI that conatains backend apis.

An alternative way can be clone this project and open folder in intellij go to run menu and click on run. this will also run your project. 
