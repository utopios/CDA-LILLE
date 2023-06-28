package com.example.correctionpetiteannonce.repository;

import com.example.correctionpetiteannonce.entity.Ad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends CrudRepository<Ad, Integer> {
}
