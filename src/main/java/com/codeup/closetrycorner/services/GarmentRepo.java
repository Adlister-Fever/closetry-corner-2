package com.codeup.closetrycorner.services;

import com.codeup.closetrycorner.models.Garment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GarmentRepo extends CrudRepository<Garment, Long> {
    @Query(value = "Select date, image, id from garments where user_id = ?1", nativeQuery = true)
    List<Garment> findGarmentsByUser(long user_id);
}
