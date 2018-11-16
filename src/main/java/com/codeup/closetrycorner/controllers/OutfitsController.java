package com.codeup.closetrycorner.controllers;

import com.codeup.closetrycorner.models.Outfit;
import com.codeup.closetrycorner.models.User;
import com.codeup.closetrycorner.services.CatSvc;
import com.codeup.closetrycorner.services.GarmentSvc;
import com.codeup.closetrycorner.services.OutfitsSvc;
import com.codeup.closetrycorner.services.UserSvc;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OutfitsController {
    private GarmentSvc garmentSvc;
    private UserSvc userSvc;
    private CatSvc catSvc;
    private OutfitsSvc outfitsSvc;

    @GetMapping("/outfits")
    public String showAllOutfits(Model vModel){
        vModel.addAttribute("outfits", outfitsSvc.findAll());
        return "outfits/show";
    }
    @GetMapping("/outfits/{id}")
    public String showOneOutfit (@PathVariable long id, Model vmodel){
        vmodel.addAttribute("outfit", outfitsSvc.findOne(id));
        return "outfits/show";
    }
    @GetMapping("/outfits/create")
    public String createOutfitForm(Model vModel){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        vModel.addAttribute("outfit", new Outfit());
        vModel.addAttribute("garments", garmentSvc.findAllForUser(user));
                return "outfits/create";
    }
    @PostMapping("/outfits/create")
    public String submitCreatedOutfit(@ModelAttribute Outfit outfit) {
        Outfit newOutfit = outfitsSvc.createOutfit(outfit);
        return "outfits/"+newOutfit.getId();
    }
}
