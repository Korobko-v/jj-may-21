package ru.levelp.jj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class MainPageController {

    @GetMapping
    public String index() {

        return "index";
    }

}
