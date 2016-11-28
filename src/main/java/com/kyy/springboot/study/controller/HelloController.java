package com.kyy.springboot.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
<<<<<<< HEAD
 * Created by kimyongyeon on 2016-06-20.
=======
 * Created by yongyeonkim on 2016. 6. 20..
>>>>>>> 8dcdb6bafe108dc87d4715a5d97e4aaff03f2bf4
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String index(Model model) {
        model.addAttribute("name", "SpringBlog from Millky");
        return "hello";
    }
}
