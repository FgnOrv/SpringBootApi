/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringFgnDailyCodeBuffer.SpringBootDailyCodeBuffer.service;

import SpringFgnDailyCodeBuffer.SpringBootDailyCodeBuffer.entity.User;
import SpringFgnDailyCodeBuffer.SpringBootDailyCodeBuffer.error.ProjectException;
import java.util.List;

/**
 *
 * @author Feqan
 */
public interface UserService {
    
    public List<User> getAllUsers() throws ProjectException;
    
    public User getUserById(Long id ) throws ProjectException;

    public User addUser(User user) throws ProjectException ;

    public User getUserByName(String name);

    public User getUserByUserName(String userName);

    public User updateUserById(Long id, User user) throws ProjectException;

    public User userDelete(Long id) throws ProjectException ;
}
