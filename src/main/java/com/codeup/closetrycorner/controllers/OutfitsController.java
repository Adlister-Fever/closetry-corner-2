package com.codeup.closetrycorner.controllers;

import com.codeup.closetrycorner.models.Garment;
import com.codeup.closetrycorner.models.Outfit;
import com.codeup.closetrycorner.models.User;
import com.codeup.closetrycorner.services.CatSvc;
import com.codeup.closetrycorner.services.GarmentSvc;
import com.codeup.closetrycorner.services.OutfitsSvc;
import com.codeup.closetrycorner.services.UserSvc;
import org.springframework.security.access.method.P;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OutfitsController {
    private GarmentSvc garmentSvc;
    private UserSvc userSvc;
    private CatSvc catSvc;
    private OutfitsSvc outfitsSvc;


    public OutfitsController(GarmentSvc garmentSvc, UserSvc userSvc, CatSvc catSvc, OutfitsSvc outfitsSvc){
        this.garmentSvc = garmentSvc;
        this.userSvc = userSvc;
        this.catSvc = catSvc;
        this.outfitsSvc = outfitsSvc;
    }

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
        User currentUser = userSvc.findOne(user.getId());
        vModel.addAttribute("outfit", new Outfit());
        vModel.addAttribute("garments", garmentSvc.findAllForUser(currentUser));
                return "outfits/create";
    }
    @PostMapping("/outfits/create")
    public String submitCreatedOutfit(@ModelAttribute Outfit outfit, @RequestParam(value = "garmentchoices") List<Garment> garments) {
        outfit.setGarments(garments);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        outfit.setUser(user);
        outfitsSvc.createOutfit(outfit);
        return "redirect:/user";
    }

    @PostMapping("/outfits/{id}/delete")
    public String deleteUserOutfit(@ModelAttribute Outfit outfit,@PathVariable long id){
        outfit = outfitsSvc.findOne(id);
        outfitsSvc.deleteOutfit(outfit);
        return "redirect:/user";
    }
}
