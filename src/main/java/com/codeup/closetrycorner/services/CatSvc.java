package com.codeup.closetrycorner.services;

import com.codeup.closetrycorner.models.Category;
import org.springframework.stereotype.Service;

@Service
public class CatSvc {
    private CategoriesRepo catRepo;


    public CatSvc(CategoriesRepo catRepo) {
        this.catRepo = catRepo;
    }

    public Iterable<Category> findAll() {
        return catRepo.findAll();
    }

    public Category findOne(long id) {
        return catRepo.findOne(id);
    }

}
