package com.codeup.closetrycorner.controllers;

import com.codeup.closetrycorner.models.Garment;
import com.codeup.closetrycorner.models.User;
import com.codeup.closetrycorner.services.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserSvc userSvc;
    private GarmentSvc garmentSvc;
    private OutfitsSvc outfitsSvc;
    private CatSvc catSvc;
    private PasswordEncoder passwordEncoder;

    public UserController(UserSvc users, PasswordEncoder passwordEncoder, GarmentSvc garmentSvc, OutfitsSvc outfitsSvc) {
        this.userSvc = users;
        this.passwordEncoder = passwordEncoder;
        this.garmentSvc = garmentSvc;
        this.outfitsSvc = outfitsSvc;
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
        model.addAttribute("garments", garmentSvc.findAllForUser(userSvc.findOne(user.getId())));
        model.addAttribute("outfits", outfitsSvc.findAllForUser(userSvc.findOne(user.getId())));
        return "users/user";
    }
    @PostMapping("/user/garment/delete/{id}")
    public String deleteGarment(@PathVariable long id){
        Garment garment = garmentSvc.findOne(id);
//        catSvc.deleteCat(garment.getCategories());
        garmentSvc.deleteGarment(garment);
        return "redirect:/user";
    }

    @GetMapping("/user/edit")
    public String showEditUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "/user";
    }

}