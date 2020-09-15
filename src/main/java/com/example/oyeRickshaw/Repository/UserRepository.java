package com.example.oyeRickshaw.Repository;
/*
 * @created 14/09/2020 - 7:59 PM
 * @project oyeRickshaw
 * @author  sheetalkumar
 */

import com.example.oyeRickshaw.Model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
}
