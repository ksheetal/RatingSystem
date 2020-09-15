package com.example.oyeRickshaw.Controller;
/*
 * @created 14/09/2020 - 7:57 PM
 * @project oyeRickshaw
 * @author  sheetalkumar
 */

import com.example.oyeRickshaw.Model.*;
import com.example.oyeRickshaw.Repository.RatingRepository;
import com.example.oyeRickshaw.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String test(){
        return "i am live!";
    }

    @RequestMapping(value = "/userSignUp", method = RequestMethod.POST)
    public String addNewUsers(@RequestBody UserModel user) throws IllegalAccessException {
        LOG.info("Inside add new user : {} ");
        UserReqResponse userReqResponse = new UserReqResponse();

        List<UserModel> users = getAllUsers();

        for (UserModel userRegisterRequest : users) {
            if (userRegisterRequest.getEmail().equals(user.getEmail())) {
                throw new IllegalAccessException("User already there!");
            }
        }

        userRepository.save(user);
        userReqResponse.setEmail(user.getEmail());
        userReqResponse.setMessage("User created successfully!");
        return "User with email-ID "+ userReqResponse.getEmail()+" created successfully!";
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<UserModel> getAllUsers() {
        LOG.info("Getting all users.");
        return userRepository.findAll();
    }

    @RequestMapping(value = "/getTotalUsers", method = RequestMethod.GET)
    public Integer getTotalNumberOfUsers() {
        LOG.info("Getting Total Number of  users.");
        return userRepository.findAll().size();
    }

    @PostMapping("/userLogin")
    public LoginReqResponse login(@RequestBody LoginRequest loginRequest) throws IllegalAccessException {

        LOG.info("inside users Login ");
        LoginReqResponse loginReqResponse = new LoginReqResponse();

        List<UserModel> users = getAllUsers();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(loginRequest.getEmail()) && users.get(i).getPassword().equals(loginRequest.getPassword())) {
                loginReqResponse.setEmail(users.get(i).getEmail());
                loginReqResponse.setRole(users.get(i).getRole());
            }
        }
        return loginReqResponse;
    }
}
