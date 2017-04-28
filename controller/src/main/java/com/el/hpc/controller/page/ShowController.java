package com.el.hpc.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;
import java.util.Date;
import java.util.Map;

/**
 * Created by ShenQi on 17/4/25.
 */
@Controller
public class ShowController {

    @RequestMapping("/")
    public String home(Map<String,Object> model){

        model.put("time",new Date());
        model.put("message","first");

        return "home";
    }

}
