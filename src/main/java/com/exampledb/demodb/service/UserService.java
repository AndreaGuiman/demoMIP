package com.exampledb.demodb.service;

import com.exampledb.demodb.model.Users;

import com.exampledb.demodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.JstlUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add(Users user){
        Optional<Users> userOptional = userRepository.findUsersByUsername(user.getUsername());
        if(userOptional.isPresent())
            throw new IllegalStateException("username taken");
        userRepository.save(user);
    }

    public List<Users> getAll(){
        return userRepository.findAll();
    }

    @Transactional
    public void update(Integer idUser, String username, String password){
        Users users = userRepository.findById(idUser).orElseThrow(()
                -> new IllegalStateException("user with id: " + idUser + " does not exist"));
        if(username != null && username.length() > 0 && !Objects.equals(users.getUsername(), username)) {
            Optional<Users> usersOptional = userRepository.findUsersByUsername(username);
            if(usersOptional.isPresent()){
                throw new IllegalStateException("username taken");
            }
            users.setUsername(username);
        }
        if(password != null && password.length() > 0 && !Objects.equals(users.getPassword(), password))
            users.setPassword(password);
    }

    public void delete(Integer idUser){
        boolean userPresent = userRepository.existsById(idUser);
        if(!userPresent){
            throw new IllegalStateException("user with id: " + idUser + " does not exist");
        }
        userRepository.deleteById(idUser);
    }

    public Users find(Integer idUser){
        return userRepository.findById(idUser).get();
    }

    public boolean findUsername(String username){
        if(userRepository.findUsersByUsername(username).isPresent()){
            return true;
        }
        return false;
    }

    public boolean findPassword(String password){
        if(userRepository.findUsersByPassword(password).isPresent()){
            return true;
        }
        return false;
    }
}
