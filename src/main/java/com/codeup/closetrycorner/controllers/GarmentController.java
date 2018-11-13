package com.codeup.closetrycorner.controllers;

import com.codeup.closetrycorner.models.Garment;
import com.codeup.closetrycorner.models.User;
import com.codeup.closetrycorner.services.CatSvc;
import com.codeup.closetrycorner.services.GarmentSvc;
import com.codeup.closetrycorner.services.UserSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GarmentController {
    private GarmentSvc garmentSvc;
    private UserSvc userSvc;
    private CatSvc catSvc;

//    public GarmentController(GarmentSvc postsvc, UserSvc usersvc, CatSvc catSvc ){
//        this.garmentSvc = garmentSvc;
//        this.userSvc = userSvc;
//        this.catSvc = catSvc;
//    }


    @GetMapping("/closet/index")
    public String showAllGarments(Model vModel){
        vModel.addAttribute("garments", garmentSvc.findAll());
        return "closet/show";

    }

    @GetMapping("/closet/{id}")
    public String showOneGarment(@PathVariable long id, Model vModel){
        vModel.addAttribute("garment", garmentSvc.findOne(id));
        return "closet/show";
    }


    @GetMapping("/closet/user/{id}")
    public String showUserGarments(@PathVariable int id, Model vModel){
        User currentUser = userSvc.findOne(id);
        vModel.addAttribute("garments", garmentSvc.findAllForUser(currentUser));
        return "closet/show";
    }

//    @GetMapping("/closet/search")
//    public String showSearchResults(Model vModel){
//        vModel.addAttribute("garments", findGarmentsByTerm)
//    }



    @GetMapping("/upload")
    public String showUploadForm(Model vModel){
        vModel.addAttribute("garment", new Garment());
        vModel.addAttribute("cats", catSvc.findAll());
        return "closet/upload";
    }
    @PostMapping("/upload")
    public String garmentUploaded(@ModelAttribute Garment garment){
        Garment newGarment = garmentSvc.uploadGarment(garment);
        return "redirect:/closet/"+newGarment.getId();
    }

}
