package com.summer.anna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EntranceController {
    /*
    訪問入口定向
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Entrance() {
        return "redirect:html/home.html";
    }
}
