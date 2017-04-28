package com.el.hpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ShenQi on 17/4/20.
 */
@Controller
public class HelloController {
    @RequestMapping("/index")
    public String index(){
        return "welcome";
    }
}


