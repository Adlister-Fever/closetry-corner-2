package com.codeup.closetrycorner.controllers;

import com.codeup.closetrycorner.services.CatSvc;
import com.codeup.closetrycorner.services.GarmentSvc;
import com.codeup.closetrycorner.services.UserSvc;
import org.springframework.stereotype.Controller;

@Controller
public class OutfitsController {
    private GarmentSvc garmentSvc;
    private UserSvc userSvc;
    private CatSvc catSvc;
//    private OutfitSvc outfitSvc;




//    @GetMapping("/outfits")
//    public String showAllOutfits(Model vModel){
//        vModel.addAttribute("outfits", outfitSvc.findAll());
//        return "/closet/outfits";
//    }
}
