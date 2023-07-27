package ua.klunniy.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.klunniy.springcourse.dao.PersonDAO;
import ua.klunniy.springcourse.models.Person;

/**
 * @author Serhii Klunniy
 */
@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    //показываем список из людей по адресу GET /people
    @GetMapping()
    public String index(Model model) {
        //этот метод будет возвращать список из людей,
        // получим всех людей из DAO и передадим на отображение в представление
        model.addAttribute("people", personDAO.index());
        return "people/index"; // здесь мы вернем тот шаблон, ту страницу что будет отображать список из людей
    }

    //показываем страницу одного человека по адресу GET /people:id
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //Получим одного человека по его id из DAO и передадим на отображение в представление
        model.addAttribute("person", personDAO.show(id));
        return "people/show"; //будет отображать одного человека
    }

    @PostMapping()
    public String create(@RequestParam("name") String name, @RequestParam("surname") String surname,
                         @RequestParam("email") String email, Model model) {
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        person.setEmail(email);

        //Добавляем человека в БД

        model.addAttribute("person", person);

        return "successPage";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @ModelAttribute("headerMessage")
    public String populateHeaderMessage() {
        return "Welcome to our website";
    }

    public String create(@ModelAttribute("person") Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }
}
