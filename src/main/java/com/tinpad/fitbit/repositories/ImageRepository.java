package com.tinpad.fitbit.repositories;

import com.tinpad.fitbit.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
    public Optional<Image> findByName(String name);
}
