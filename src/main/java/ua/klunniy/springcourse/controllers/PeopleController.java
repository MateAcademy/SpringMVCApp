package ua.klunniy.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Serhii Klunniy
 */
@Controller
@RequestMapping("/people")
public class PeopleController {

    @GetMapping
    public String index(Model model) {
        //этот метод будет возвращать список из людей, получим всех людей из DAO и передадим на отображение в представление
        return null;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //Получим одного человека по id из DAO и передадим на отображение в представление
        return null;
    }
}
