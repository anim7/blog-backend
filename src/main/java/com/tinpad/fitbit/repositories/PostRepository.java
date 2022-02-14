package com.tinpad.fitbit.repositories;

import com.tinpad.fitbit.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    public Optional<Post> findBySlug(String slug);
}
