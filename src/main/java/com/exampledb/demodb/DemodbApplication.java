package com.exampledb.demodb;

import com.exampledb.demodb.model.Users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemodbApplication.class, args);
        System.out.println("xd");
//        Users user = new Users();
//        user.setUsername("Andrei");
//        user.setPassword("andrei123");

//        UserService userService = new UserService();
//        userService.addUser(user);

//        UserService userApi = new UserService();
//        System.out.println(userApi.getAllUsers());

    }

}
