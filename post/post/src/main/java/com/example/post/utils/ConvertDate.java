package com.example.post.utils;

import com.example.post.exceptions.GlobalException;
import jakarta.persistence.Column;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ConvertDate {


    public Date convertDate(String dateString)  {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            throw new GlobalException("Problème de conversion date");
        }

        return date;

    }
}
