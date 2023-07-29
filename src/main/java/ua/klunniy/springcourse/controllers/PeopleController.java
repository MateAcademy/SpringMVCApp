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
    //это означает что мы поместим число и это число передастся в аргументы метода, с помощью аннотации
    //PathVariable мы извлечем id из url-a из адреса и получи м доступ к id внутри метода
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //Получим одного человека по его id из DAO и передадим на отображение в представление
        model.addAttribute("person", personDAO.show(id));
        return "people/show"; //будет отображать одного человека
    }

    @PostMapping("/create")
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

//    @GetMapping("/new")
//    public String newPerson(Model model) {
//        model.addAttribute("person", new Person());
//        return "people/new";
//
//    }

    //Этот метод будет возвращать html форму для создания нового человека
    //мы не посылаем поля для обьекта класса Person
    //ModelAttribute создаст пустой обьект класса Person и поместит его в Model
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    //а второй метод будет принимать на вход POST запрос, будет брать данные из этого запроса,
    @PostMapping
    public String create(@ModelAttribute("person") Person person) {
        //создает обьект
        //считывает данные из поля
        //помещает эти данные в обьект
        //помещает обьект в модель
        personDAO.save(person);
        return "redirect:/people";
    }

    @ModelAttribute("headerMessage")
    public String populateHeaderMessage() {
        return "Welcome to our website";
    }
}
