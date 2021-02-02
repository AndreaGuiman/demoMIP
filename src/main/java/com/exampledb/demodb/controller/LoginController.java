package com.exampledb.demodb.controller;

import com.exampledb.demodb.model.Users;
import com.exampledb.demodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/login")
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String checkLogin(@RequestBody Users users){
        String username = users.getUsername();
        String password = users.getPassword();
        if(userService.findUsername(username) && userService.findPassword(password)){
            return "found";
        }
        return "!found";
    }
}
