package com.example.studyhtmx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = {"", "/"})
    public String index() {
        return "redirect:/todo";
    }
}
