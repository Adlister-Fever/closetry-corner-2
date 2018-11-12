package com.codeup.closetrycorner.services;

import com.codeup.closetrycorner.models.Garment;
import com.codeup.closetrycorner.models.User;
import org.springframework.stereotype.Service;

@Service
public class GarmentSvc {
    private GarmentRepo garmentRepo;

    public Iterable<Garment> findAll() {
        return garmentRepo.findAll();
    }

    public Garment findOne(int id) {
        return garmentRepo.findOne(id);
    }

    public Garment uploadGarment(Garment garment) {
        return garmentRepo.save(garment);
    }

    public Iterable<Garment> findAllForUser(User user){
        return garmentRepo.findGarmentsByUser(user.getId());

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
