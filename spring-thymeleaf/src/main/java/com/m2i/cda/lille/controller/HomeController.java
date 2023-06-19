package com.m2i.cda.lille.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HomeController {


    @RequestMapping("/")
    public String getHome(){

        return "Hello les coupins";
    }
    @RequestMapping("/toto")
    public String getToto(){

        return "Salut c'est le";
    }

    @RequestMapping(value = "/test/demo", method = RequestMethod.GET)
    public String getTest(){
        return "C'est juste une test";
    }

    @RequestMapping(value = "/header/demo",headers = "Accept=text/html",  method = RequestMethod.GET)
    public String getTest2(){
        return "C'est une demo header";
    }

    @GetMapping("/get")
    public String pageGet(){
        return "Je suis une page pour une get";
    }

    @PostMapping("/post")
    public String pagePost(){
        return "Je suis un post";
    }

    @GetMapping("/get/{data}")
    public String getData(@PathVariable("data") Integer id){
        return "Je suis un get et voila la valeur de data est : " + id;
    }

    @GetMapping("/get/{data}/autre/{data2}")
    public String getData(@PathVariable("data") Integer id, @PathVariable("data2") Integer id2){
        return "Je suis un get et voila la valeur de data est : " + id + " l'autre data2 est de " + id2;
    }


    @GetMapping("/getParams")
    public String getParam(@RequestParam("id") Integer id){
        return "Le param est : " + id;
    }

}
