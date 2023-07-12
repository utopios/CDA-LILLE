package com.example.aopspring;

import com.example.aopspring.business.BusinessService1;
import com.example.aopspring.business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopSpringApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    BusinessService1 businessService1;

    @Autowired
    BusinessService2 businessService2;



    public static void main(String[] args) {
        SpringApplication.run(AopSpringApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {

        logger.info("BusinessService1 value returned is {} ", businessService1.checkMax(45));
        logger.info("BusinessService2 value returned is {} ", businessService2.checkMin(160));



    }
}
