package com.codeup.closetrycorner.services;

import com.codeup.closetrycorner.models.Outfit;
import com.codeup.closetrycorner.models.User;

public class OutfitsSvc {
    private OutfitsRepo outfitsRepo;

    public Iterable<Outfit> findAll(){ return outfitsRepo.findAll();}

    public Outfit findOne(int id) {return outfitsRepo.findOne(id);}

    public Outfit createOutfit (Outfit outfit) { return outfitsRepo.save(outfit);}

    public Iterable<Outfit> findAllForUser(User user){
        return outfitsRepo.findOutfitsByUser(user.getId());
    }

    public void saveOutfit(Outfit outfit){
        outfitsRepo.save(outfit);
    }

    public Outfit editOutfit(Outfit outfit){
        return outfitsRepo.save(outfit);
    }

    public void deleteOutfit (Outfit outfit){
        outfitsRepo.delete(outfit);
    }
}
