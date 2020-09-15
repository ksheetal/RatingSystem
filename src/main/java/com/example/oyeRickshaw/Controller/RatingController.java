package com.example.oyeRickshaw.Controller;
/*
 * @created 14/09/2020 - 8:26 PM
 * @project oyeRickshaw
 * @author  sheetalkumar
 */

import com.example.oyeRickshaw.Model.RatingModel;
import com.example.oyeRickshaw.Repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class RatingController {

    private final RatingRepository ratingRepository;
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    public RatingController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }


    @PostMapping("/rateRide")
    public String RateRide(@RequestBody RatingModel ratingModel) throws IllegalAccessException {
        LOG.info("inside Rating: {Enter} ");

        ratingRepository.save(ratingModel);

        LOG.info("inside Rating: {Exit} ");
        return "you have given " + ratingModel.getRating() + " rating !";
    }

    @RequestMapping(value = "/getAvgRatingByDriverID/{driverID}", method = RequestMethod.GET)
    public String getAvgRatingRideByDriverID(@PathVariable String driverID) {
        LOG.info("Getting all Ride by driver ID.");
        System.out.println("driverID - " + driverID);

        List<RatingModel> allRating = ratingRepository.findAll();
        double avgRating = 0.0;
        int totalRide = 0;

        // avg rating  = total dive rating / total drive
        for (int i = 0; i < allRating.size(); i++) {
            if (allRating.get(i).getDriverID().equals(driverID) && allRating.get(i).getRatedBy().equalsIgnoreCase("Driver")) {
                avgRating = avgRating + allRating.get(i).getRating();
                totalRide++;
            }
        }
        return "Driver's rating is " + Float.valueOf((float) (avgRating / totalRide)) + "!";
    }

    @RequestMapping(value = "/getAvgRatingByUserID/{userID}", method = RequestMethod.GET)
    public String getAvgRatingRideByUserID(@PathVariable String userID) {
        LOG.info("Getting all Ride by user ID.");
        System.out.println("userID - " + userID);
        // fetching all details
        List<RatingModel> allRating = ratingRepository.findAll();
        double avgRating = 0.0;
        int totalRide = 0;

        for (int i = 0; i < allRating.size(); i++) {
            if (allRating.get(i).getUserID().equals(userID) && allRating.get(i).getRatedBy().equalsIgnoreCase("User")) {
                avgRating = avgRating + allRating.get(i).getRating();
                totalRide++;
            }
        }
        return "User's rating is " + Float.valueOf((float) (avgRating / totalRide)) + "!";
    }
}
