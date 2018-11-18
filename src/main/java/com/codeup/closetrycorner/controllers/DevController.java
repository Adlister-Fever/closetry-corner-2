package com.codeup.closetrycorner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//get mapping for /
//return string that says this is the landing pge
@Controller
public class DevController {
    @GetMapping("/devs")
    public String landing(){
        return "devs";
    }
}
