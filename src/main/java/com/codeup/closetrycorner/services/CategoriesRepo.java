package com.codeup.closetrycorner.services;

import com.codeup.closetrycorner.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriesRepo extends CrudRepository<Category, Long> {
}
