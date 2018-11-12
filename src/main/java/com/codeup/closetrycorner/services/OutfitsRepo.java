package com.codeup.closetrycorner.services;

import com.codeup.closetrycorner.models.Outfit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OutfitsRepo extends CrudRepository<Outfit, Integer> {
    @Query(value = "Select date, image, id from garments where user_id = ?1", nativeQuery = true)
    List<Outfit> findOutfitsByUser(int user_id);
}
