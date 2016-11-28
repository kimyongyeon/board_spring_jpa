package com.kyy.springboot.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kimyongyeon on 2016-06-20.
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String index(Model model) {
        model.addAttribute("name", "SpringBlog from Millky");
        return "hello";
    }
}
