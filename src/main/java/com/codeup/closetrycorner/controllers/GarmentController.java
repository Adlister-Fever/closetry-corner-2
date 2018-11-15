package com.codeup.closetrycorner.controllers;

import com.codeup.closetrycorner.models.Category;
import com.codeup.closetrycorner.models.Garment;
import com.codeup.closetrycorner.models.User;
import com.codeup.closetrycorner.services.CatSvc;
import com.codeup.closetrycorner.services.GarmentSvc;
import com.codeup.closetrycorner.services.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import java.util.List;


@Controller
public class GarmentController {
    private GarmentSvc garmentSvc;
    private UserSvc userSvc;
    private CatSvc catSvc;


    public GarmentController(GarmentSvc garmentSvc, UserSvc userSvc, CatSvc catSvc ){
        this.garmentSvc = garmentSvc;
        this.userSvc = userSvc;
        this.catSvc = catSvc;
    }

    @GetMapping("/closet/{id}")
    public String showOneGarment(@PathVariable long id, Model vModel){
        vModel.addAttribute("garment", garmentSvc.findOne(id));
        return "closet/show";
    }


    @GetMapping("/closet/user/{id}")
    public String showUserGarments(@PathVariable long id, Model vModel){
        User currentUser = userSvc.findOne(id);
        vModel.addAttribute("garments", garmentSvc.findAllForUser(currentUser));
        return "closet/show-user";
    }

    @GetMapping("/upload")
    public String showUploadForm(Model vModel){
        vModel.addAttribute("garment", new Garment());
        vModel.addAttribute("cats", catSvc.findAll());
        return "closet/upload";
    }
    @PostMapping("/upload")
    public String garmentUploaded(@ModelAttribute Garment garment,@RequestParam(value = "categories") List<Category> categories){
        garment.setCategories(categories);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        garment.setUser(userSvc.findOne(user.getId()));
        garmentSvc.saveGarment(garment);
//        garmentSvc.saveGarment(garment);
        return "redirect:/user";
    }


    //show search form
    @GetMapping("/closet/search")
    public String showSearchForm(){
        return "closet/user";
    }

    //search and return garments based on search term (category name)
    @PostMapping("/closet/search")
    public String searchUserGarments(@ModelAttribute Garment garment,  @RequestParam(name = "name") String name){
        Category category = new Category(name);
        garmentSvc.searchGarment(category);

        return "closet/user";
    }


}
