package com.github.bootstrap.service;

import com.github.bootstrap.exception.UserNotFoundException;
import com.github.bootstrap.model.Review;
import com.github.bootstrap.model.User;
import com.github.bootstrap.repository.ReviewRepository;
import com.github.bootstrap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserReviewService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ReviewRepository reviewRepository;

    public List<User> getAllUsers() {
        List<User> result = (List<User>) userRepository.findAll();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<User>();
        }
    }

    public User createUpdateUser(User user) {
        if (user.getId() == null) {
            user = userRepository.save(user);

            return user;
        } else {
            Optional<User> entity = userRepository.findById(user.getId());

            if (entity.isPresent()) {
                User newUser = entity.get();
                newUser.setName(user.getName());
                newUser = userRepository.save(newUser);

                return newUser;
            } else {
                user = userRepository.save(user);

                return user;
            }
        }
    }

}
