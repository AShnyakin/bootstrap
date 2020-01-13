package com.github.bootstrap.service;

import com.github.bootstrap.exception.UserNotFoundException;
import com.github.bootstrap.model.User;
import com.github.bootstrap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> getAllUsers() {
        List<User> result = (List<User>) repository.findAll();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<User>();
        }
    }

    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = repository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("No user record exist for given id");
        }
    }

    public User createUpdateUser(User user) {
        if (user.getId() == null) {
            user = repository.save(user);

            return user;
        } else {
            Optional<User> entity = repository.findById(user.getId());

            if (entity.isPresent()) {
                User newUser = entity.get();
                newUser.setName(user.getName());
                newUser = repository.save(newUser);

                return newUser;
            } else {
                user = repository.save(user);

                return user;
            }
        }
    }

}
