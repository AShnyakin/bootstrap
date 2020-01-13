package com.github.bootstrap.controller;

import com.github.bootstrap.model.User;
import com.github.bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserReviewController {

    @Autowired
    UserService userService;

    @RequestMapping
    public String getAllUserReviews(Model model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("user", new User());
        model.addAttribute("users", list);
        return "home";
    }

    @RequestMapping(path = "/createUser", method = RequestMethod.POST)
    public String createOrUpdateUser(User user) {
        userService.createUpdateUser(user);
        return "redirect:/";
    }

}