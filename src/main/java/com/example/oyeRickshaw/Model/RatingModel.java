package com.example.oyeRickshaw.Model;
/*
 * @created 14/09/2020 - 8:14 PM
 * @project oyeRickshaw
 * @author  sheetalkumar
 */

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RatingModel {

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
    private String ratedBy;

    public RatingModel() {
    }

    public RatingModel(String driveID, @NonNull String driverID, @NonNull String userID, @NonNull Integer rating, @NonNull String review, @NonNull String ratedBy) {
        this.driveID = driveID;
        this.driverID = driverID;
        this.userID = userID;
        this.rating = rating;
        this.review = review;
        this.ratedBy = ratedBy;
    }

    public String getDriveID() {
        return driveID;
    }

    public void setDriveID(String driveID) {
        this.driveID = driveID;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRatedBy() {
        return ratedBy;
    }

    public void setRatedBy(String ratedBy) {
        this.ratedBy = ratedBy;
    }
}
