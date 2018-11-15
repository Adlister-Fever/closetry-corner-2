package com.codeup.closetrycorner.services;

import com.codeup.closetrycorner.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    public List<Category> findOne(String name) { return catRepo.findCategoryByName(name);}

}
