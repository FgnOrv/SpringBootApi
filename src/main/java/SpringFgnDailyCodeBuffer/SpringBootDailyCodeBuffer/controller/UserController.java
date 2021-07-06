/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringFgnDailyCodeBuffer.SpringBootDailyCodeBuffer.controller;

import SpringFgnDailyCodeBuffer.SpringBootDailyCodeBuffer.entity.User;
import SpringFgnDailyCodeBuffer.SpringBootDailyCodeBuffer.error.ProjectException;
import SpringFgnDailyCodeBuffer.SpringBootDailyCodeBuffer.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() throws ProjectException {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id) throws ProjectException {
        return userService.getUserById(id);
    }

    @GetMapping("/user/name/{name}")
    public User getByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/user/userName/{userName}")
    public User getUserByUserName(@PathVariable String userName) {
        return userService.getUserByUserName(userName);
    }

    @PostMapping("/userInsert")
    public User addUser(@RequestBody User user) throws ProjectException {
        return userService.addUser(user);
    }

    @PostMapping("/userUpdate/{id}")
    public User updateUser(@PathVariable("id") Long id , @RequestBody User user)  throws ProjectException {
        return userService.updateUserById(id, user);
    }
    
    @PostMapping("/userDelete/{id}")
    public User userDelete(@PathVariable("id") Long id ) throws ProjectException{
        return userService.userDelete(id);
    }
}
