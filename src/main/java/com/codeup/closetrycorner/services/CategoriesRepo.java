package com.codeup.closetrycorner.services;

import com.codeup.closetrycorner.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepo extends CrudRepository<Category, Long> {
}
