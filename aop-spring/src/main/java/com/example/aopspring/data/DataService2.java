package com.example.aopspring.data;

import com.example.aopspring.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {


    @TrackTime
    public int[] retourneData (){

        try{
            Thread.sleep(30);
        } catch (InterruptedException e) {
           e.fillInStackTrace();
        }

        return new int[]{111,222,656,444,628,121};

    }





}
