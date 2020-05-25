package cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloConteroller {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){

        return "hello";
    }
    @RequestMapping("/enterpriseTalent")
    public String enterpriseTalent(){

        return "enterpriseTalent";
    }
}
