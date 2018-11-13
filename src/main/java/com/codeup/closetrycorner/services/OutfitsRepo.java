package com.codeup.closetrycorner.services;

import com.codeup.closetrycorner.models.Outfit;
import com.codeup.closetrycorner.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OutfitsRepo extends CrudRepository<Outfit, Long> {
//    @Query(value = "Select date, image, id from garments where user_id = ?1", nativeQuery = true)
    List<Outfit> findByUser(User user);
}
