package com.example.oyeRickshaw.Repository;



import com.example.oyeRickshaw.Model.RatingModel;
import com.example.oyeRickshaw.Model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends MongoRepository<RatingModel, String> {
}
