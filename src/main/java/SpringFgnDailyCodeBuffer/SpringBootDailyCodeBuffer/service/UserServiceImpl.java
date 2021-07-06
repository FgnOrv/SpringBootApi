/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringFgnDailyCodeBuffer.SpringBootDailyCodeBuffer.service;

import SpringFgnDailyCodeBuffer.SpringBootDailyCodeBuffer.entity.User;
import SpringFgnDailyCodeBuffer.SpringBootDailyCodeBuffer.error.ProjectException;
import SpringFgnDailyCodeBuffer.SpringBootDailyCodeBuffer.repository.UserRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() throws ProjectException{
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new ProjectException("No user exists ");
        }
        return users;
    }

    @Override
    public User getUserById(Long id) throws ProjectException {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new ProjectException("No user found with " + id + " id ");
        }
        return user.get();
    }

    @Override
    public User addUser(User user) throws ProjectException {
        if (userRepository.findAllByUserName(user.getUserName()) != null) {
            throw new ProjectException("Username must be unique");
        }
        return userRepository.save(user);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findAllByFirstName(name);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findAllByUserName(userName);
    }

    @Override
    public User updateUserById(Long id, User user) throws ProjectException {
        Optional<User> checkOb = userRepository.findById(id);

        if (!checkOb.isPresent()) {
            throw new ProjectException("No user found with " + id + " id ");
        } else {

            User changedUserOb = userRepository.findById(id).get();

            if (Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())) {
                changedUserOb.setFirstName(user.getFirstName());
            }
            if (Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())) {
                changedUserOb.setLastName(user.getLastName());
            }
            if (Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())) {

                if (userRepository.findAllByUserName(user.getUserName()) != null) {
                    throw new ProjectException("Username must be unique");
                }

                changedUserOb.setUserName(user.getUserName());
            }
            return userRepository.save(changedUserOb);
        }
    }

    @Override
    public User userDelete(Long id) throws ProjectException {

        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new ProjectException("No user found with " + id + " id ");
        } else {
            String firstName = user.get().getFirstName();
            String lastName = user.get().getLastName();
            String userName = user.get().getUserName();

            userRepository.deleteById(id);

            return new User(id, firstName, lastName, userName);
        }
    }

}
