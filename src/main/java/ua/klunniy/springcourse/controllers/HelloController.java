package ua.klunniy.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Serhii Klunniy
 */
@Controller
public class HelloController {

    //    @RequestMapping({"/hello"})
//    @ResponseBody
    @GetMapping("/hello-world")
    public String sayHello() {
        return "hello_world";
    }
}
