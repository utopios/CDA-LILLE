package com.example.aopspring.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] retourneData ()  {

        try{
            Thread.sleep(30);
        }catch (InterruptedException ex){
           ex.fillInStackTrace();
        }


        return new int[]{11,22,65,44,62,12};

    }





}
