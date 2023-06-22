package com.m2i.cda.product.service.impl;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ColorService {

    @Autowired
    private HttpServletRequest request;

    public String getColor() {
        String color = "";
      if(request.getCookies()!=null) {
          for (Cookie cookie : request.getCookies()) {
              if (cookie.getName().equals("color")) {
                  color = cookie.getValue();
                  break;
              }
          }
      }else{
          color="red";
      }
        return color;
    }
}

