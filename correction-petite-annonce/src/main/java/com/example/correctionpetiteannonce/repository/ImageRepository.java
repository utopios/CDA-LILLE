package com.example.correctionpetiteannonce.repository;

import com.example.correctionpetiteannonce.entity.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer> {
}
