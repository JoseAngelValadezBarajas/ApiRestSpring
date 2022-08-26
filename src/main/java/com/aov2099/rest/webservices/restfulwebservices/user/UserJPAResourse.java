package com.aov2099.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;;

@RestController
public class UserJPAResourse {

    @Autowired //Creates an istance of the DAO Class
    private UserDaoService service;
    
    @Autowired
    private UserRepository userRepository;
    
    //GET /users
    //retrieveAllUsers
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    //GET /users/id
    //retrieveUser(int id)
   @GetMapping("/jpa/users/{id}")
    public Optional<User> retrieveUser(@PathVariable int id){
        return userRepository.findById(id);
    }

    //POST
    //input -details of user
    //output - CREATED & Return the created URI
    @PostMapping("/jpa/user")
    public void createUser(@RequestBody User user ){
        User savedUser = userRepository.save(user);
    } 

}
