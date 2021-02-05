package com.company.springbootgradledockeraws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPageController {

//    @RequestMapping("/hello")
    @GetMapping("/hello")
    public String get() {
        return "Hello!";
    }


//    @GetMapping("/index")
//    public String commentForm(Model model) {
//        model.addAttribute("view", new Comment());
//        return "index";
//    }

//    @PostMapping("/index")
//    public String commentSubmit(@ModelAttribute Comment comment, Model model) {
//        model.addAttribute("comment", comment);
//        return "index";
//    }
}
