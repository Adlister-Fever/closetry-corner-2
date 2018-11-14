package com.codeup.closetrycorner.services;

import com.codeup.closetrycorner.models.Category;
import com.codeup.closetrycorner.models.Garment;
import com.codeup.closetrycorner.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GarmentSvc {
    @Autowired
    private GarmentRepo garmentRepo;

    public Iterable<Garment> findAll() {
        return garmentRepo.findAll();
    }

    public Garment findOne(long id) {
        return garmentRepo.findOne(id);
    }

    public Garment uploadGarment(Garment garment) {
        return garmentRepo.save(garment);
    }

    public Iterable<Garment> findAllForUser(User user){
        return garmentRepo.findByUser(user);

    }

    public Iterable<Garment> searchGarment(Category category) {
        return garmentRepo.findGarmentsByCategories(category);
    }

    public void saveGarment(Garment garment){
        garmentRepo.save(garment);
    }

    public Garment editGarment(Garment garment) {
        return garmentRepo.save(garment);
    }

    public void deleteGarment(Garment garment) {
        garmentRepo.delete(garment);
    }


}
