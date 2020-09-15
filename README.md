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
