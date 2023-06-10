package ua.klunniy.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
