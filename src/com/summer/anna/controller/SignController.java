package com.summer.anna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/*
截取POST
 */
@RequestMapping("/html")
public class SignController {
    @RequestMapping(value = "LoginAction", method = RequestMethod.POST)
    public String CheckSignIn(){
        System.out.println("成功");
        if (true){
            return "redirect:BlogList.html";
        }
        return "about.html";
    }
}
