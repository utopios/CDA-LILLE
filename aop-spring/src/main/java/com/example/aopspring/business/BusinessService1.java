package com.example.aopspring.business;

import com.example.aopspring.annotations.TrackTime;
import com.example.aopspring.data.DataService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    @Autowired
    private DataService1 dataService1;


    @TrackTime
    public int checkMax(int val){
        int[] data = dataService1.retourneData();

        return Arrays.stream(data).max().orElse(0);
    }




}
