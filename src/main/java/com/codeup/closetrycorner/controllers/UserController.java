package com.codeup.closetrycorner.controllers;

import com.codeup.closetrycorner.models.User;
import com.codeup.closetrycorner.services.GarmentSvc;
import com.codeup.closetrycorner.services.OutfitsSvc;
import com.codeup.closetrycorner.services.UserSvc;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserSvc userSvc;
    private GarmentSvc garmentSvc;
    private OutfitsSvc outfitsSvc;
    private PasswordEncoder passwordEncoder;

    public UserController(UserSvc users, PasswordEncoder passwordEncoder) {
        this.userSvc = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userSvc.save(user);
        return "redirect:/login";
    }
    @GetMapping("/user")
    public String showProfile(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("garments", garmentSvc.findAllForUser(user));
        model.addAttribute("outfits", outfitsSvc.findAllForUser(user));
        return "users/user";
    }

//    @GetMapping("/user/followers")
//    public String showFollowers(Model model){
//
//    }
}