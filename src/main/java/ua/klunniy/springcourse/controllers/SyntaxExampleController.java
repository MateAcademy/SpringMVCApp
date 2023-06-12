package ua.klunniy.springcourse.controllers;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.klunniy.springcourse.models.EmployeeDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Serhii Klunniy
 * https://itvdn.com/ru/video/thymeleaf
 */
@Controller
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SyntaxExampleController {
    static final String INDEX_PAGE = "syntaxExample";
    static final String INDEX_EXAMPLE_LNK = "/syntax/example";

    @GetMapping(value = "/syntax/example")
    public String getSyntaxExamplePage(Model model) {
        model.addAttribute("defaultName", "Peter Parker");
        model.addAttribute("greetings", "Hello World");
//        model.addAttribute("employee", getTestEmployee());
//        model.addAttribute("employeeMap", getMapWithEmployee());
//        model.addAttribute("employeeList", getListOfEmployee());
        model.addAttribute("companiesUrl", "/api/companies");
//        model.addAttribute("employeeObject", getTestEmployee());
        return INDEX_PAGE;
    }

    private Map<String, EmployeeDto> getMapWithEmployees() {
        Map<String, EmployeeDto> employeeMap = new HashMap<>();
//        employeeMap.put("Peter", getTestEmployee());
        return employeeMap;
    }

//    private List<EmployeeDto> getListOfEmployees() {
//        EmployeeDto first = getTestEmployee();
//        EmployeeDto second = getTestEmployee();
//        second.setFirstName("Jon");
//        second.setLastName("Malkovich");
//        second.setEmail("malkovich@gmail.com");
//    }
}
