package com.example.correctiontodolist.repository.impl;

import com.example.correctiontodolist.entity.Image;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image,Integer> {


}
