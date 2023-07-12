package com.example.aopspring.business;

import com.example.aopspring.data.DataService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {

    @Autowired
    private DataService2 dataService2;
    public int checkMin(int val){
        int[] data = dataService2.retourneData();

        return Arrays.stream(data).min().orElse(0);
    }




}
