/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdg.cdg.controllers;

/**
 *
 * @author victorpuch
 */
import com.cdg.cdg.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.cdg.cdg.repositories.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method=RequestMethod.GET, value="/users")
    public Iterable<User> user() {
        return userRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/users")
    public User save(@RequestBody User user) {
        user.setStatus("A");
        userRepository.save(user);
        return user;
    }

    @RequestMapping(method=RequestMethod.GET, value="/users/{id}")
    public Optional<User> show(@PathVariable String id) {
        return userRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
    public User update(@PathVariable String id, @RequestBody User user) {
        Optional<User> optuser = userRepository.findById(id);
        User u = optuser.get();
        if(user.getName() != null)
            u.setName(user.getName());
        if(user.getPassword() != null)
            u.setName(user.getPassword());
        if(user.getLevel() != null)
            u.setName(user.getLevel()); 
         if(user.getGroup_id() != null)
            u.setName(user.getGroup_id());
        userRepository.save(u);
        return u;
    }

    @RequestMapping(method=RequestMethod.PUT, value="/users/delete/{id}")
    public User delete(@PathVariable String id) {
        Optional<User> optuser = userRepository.findById(id);
        User u = optuser.get();
        u.setStatus("B");
        userRepository.save(u);
        return u;
    }
    
     @RequestMapping(method=RequestMethod.PUT, value="/users/activate/{id}")
        public User activate(@PathVariable String id) {
        Optional<User> optuser = userRepository.findById(id);
        User u = optuser.get();
        u.setStatus("A");
        userRepository.save(u);
        return u;
    }
}
