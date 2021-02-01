package com.exampledb.demodb.controller;

import com.exampledb.demodb.model.Users;
import com.exampledb.demodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/demoDB")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping
    public Users addUser(@RequestBody Users users){
        userService.add(users);
        return users;
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return userService.getAll();
    }

    @PutMapping(path = "{idUser}")
    public Users updateUser(@PathVariable("idUser") Integer idUser,
                            @RequestBody Users users){
        userService.update(idUser, users.getUsername(), users.getPassword());
        return userService.find(idUser);
    }

    @DeleteMapping(path = "{idUser}")
    public void deleteUser(@PathVariable("idUser") Integer idUser){
        userService.delete(idUser);
    }
}
