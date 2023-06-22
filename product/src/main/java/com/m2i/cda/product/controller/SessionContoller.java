package com.m2i.cda.product.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("http-session")
@ResponseBody
public class SessionContoller {


    @Autowired
    HttpSession _httpsession;


    @GetMapping("ecrire")
    public String write() {
        _httpsession.setMaxInactiveInterval(60);
        _httpsession.setAttribute("name", "mohamed");
        return "OK";

    }


    @GetMapping("ecrire-list")
    public String writeList() {
        List<String> liste = Arrays.asList("Karim", "Paul", "Pierre");
        _httpsession.setMaxInactiveInterval(30);
        _httpsession.setAttribute("liste", liste);
        return "OK";

    }


    @GetMapping("lire")
    public String read() {
        return _httpsession.getAttribute("name").toString();
    }


    @GetMapping("lire-list")
    public List<String> readList() {
        return (List<String>) _httpsession.getAttribute("liste");
    }



    @GetMapping("remove")
    public String remove(){
        _httpsession.removeAttribute("name");
        return "Supression Ok";
    }



}
