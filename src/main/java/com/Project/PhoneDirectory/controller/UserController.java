package com.Project.PhoneDirectory.controller;


import com.Project.PhoneDirectory.model.UserLogin;
import com.Project.PhoneDirectory.model.UserSignUp;
import com.Project.PhoneDirectory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    //Mapping for login user - Get request
    @RequestMapping(method = RequestMethod.GET, value = "/users/login")
    public String loginUser(Model model){
        model.addAttribute("user", new UserLogin());
        return "users/login";
    }

    //Mapping to check user credentials - Post request
    @RequestMapping(method = RequestMethod.POST, value = "/users/login")
    public String checkUser(UserLogin user , HttpSession session){
        UserLogin existingUser = userService.loginUser(user);
        if(existingUser == null){
            System.out.println("User not exist");
            return "redirect:/users/login";
        }else {
            // Maintain the session
            session.setAttribute("LoggedUser", existingUser);
            return "userdata";
        }
    }

    //Mapping to register user - Get request
    @RequestMapping(method = RequestMethod.GET, value = "/users/registration")
    public String register(Model model){
        UserLogin userLogin = new UserLogin();
        UserSignUp userSignUp = new UserSignUp();
        userLogin.setUserSignUp(userSignUp);
        model.addAttribute("user", new UserLogin());
        return "users/registration";

    }

    //Mapping to register user - Post request
    @RequestMapping(method = RequestMethod.POST, value = "/users/registration")
    public String registerUser(UserLogin user){
         userService.registerUser(user);
         return "redirect:/users/login";
    }


}
