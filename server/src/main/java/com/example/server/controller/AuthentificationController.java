package com.example.server.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import com.example.server.domain.User;
import com.example.server.form.UserForm;
import com.example.server.service.UserService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AuthentificationController {
    @Inject
    UserService userService;

    @ModelAttribute
    public UserForm setUserForm(){
        return new UserForm();
    }

    @RequestMapping(value="authenticate",method = RequestMethod.POST)
    public User login(@RequestBody User user, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return userService.login(user);
    }
}