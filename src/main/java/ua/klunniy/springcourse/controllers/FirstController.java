package ua.klunniy.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Serhii Klunniy
 */
@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println("Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/hello-world")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
//        System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) Integer a,
                             @RequestParam(value = "b", required = false) Integer b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {
        double result = 0;
        if (action != null && a != null && b != null)
            switch (action) {
                case "multiplication" -> result = a * b;
                case "addition" -> result = a + b;
                case "subtraction" -> result = a - b;
                case "division" -> result = (double) a / b;
            }
        model.addAttribute("message", "Answer: " + result);
        return "first/calculator";
    }

    @GetMapping("/calculator2")
    public String calculator2(Integer a, Integer b, String action, Model model) {
        double result = 0;
        if (action != null && a != null && b != null)
            switch (action) {
                case "multiplication" -> result = a * b;
                case "addition" -> result = a + b;
                case "subtraction" -> result = a - b;
                case "division" -> result = (double) a / b;
            }
        model.addAttribute("message", "Answer: " + result);
        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
