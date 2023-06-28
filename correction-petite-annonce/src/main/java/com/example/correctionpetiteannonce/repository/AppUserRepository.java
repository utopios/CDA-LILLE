package com.example.correctionpetiteannonce.repository;

import com.example.correctionpetiteannonce.entity.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    public AppUser findByEmailAndPassword(String email, String password);

    public AppUser findByEmail(String email);
}
