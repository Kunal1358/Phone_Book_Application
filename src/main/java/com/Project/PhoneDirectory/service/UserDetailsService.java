package com.Project.PhoneDirectory.service;

import com.Project.PhoneDirectory.model.UserDetails;
import com.Project.PhoneDirectory.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    //Method to get all user details enter by logged user
    public List<UserDetails> getAllUserDetails(Integer userId){

        return userDetailsRepository.getAllUserDetails(userId);
    }

    //Method to create a new entry
    public void createDetails(UserDetails newEntry){
        userDetailsRepository.createDetails(newEntry);
    }

    //Method to delete a entry
    public void deleteDetail(Integer userId){
        userDetailsRepository.deleteDetails(userId);
    }

    //Method to get a entry
    public UserDetails getPost(Integer userId) {
        return userDetailsRepository.getPost(userId);
    }


}
