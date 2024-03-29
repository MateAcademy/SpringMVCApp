package ua.klunniy.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.klunniy.springcourse.dao.PersonDAO;
import ua.klunniy.springcourse.models.Person;


import javax.validation.Valid;

/**
 * @author Serhii Klunniy
 */
@Controller
@RequestMapping("/people")
public class PeopleController {

   /**
    * REST описывает то какие URLы и HTTP методы у нас должны быть для взаимодействия с данными
    *
    *
    *   С GET запросом вот по этому URL мы получим все записи:
    *   GET     /posts               Получаем все записи(READ)
    *
    *   GET     /posts/:id          Получаем одну запись(READ)
    *   DELETE  /posts/:id          Удаляем запись(DELETE)
    *
    *   GET     /posts/new           HTML форма создания записи
    *   POST    /posts               Создаем новую запись(CREATE)
    *
    *   GET     /posts/:id/edit     HTML форма редактирования записи
    *   PATCH   /posts/:id          Обновляем запись(UPDATE)
    *
    * */

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    //показываем список из людей по адресу GET /people
    @GetMapping()
    public String index(Model model) {
        //этот метод будет возвращать список из людей,
        // Получим всех людей из DAO и передадим на отображение в представление
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

    @PostMapping("/")
    public String create(@ModelAttribute("person") Person person) {
        //Добавляем человека в БД
        personDAO.save(person);
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
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "people/new";
        }
        //создает обьект
        //считывает данные из поля
        //помещает эти данные в обьект
        //помещает обьект в модель
        personDAO.save(person);
        // return "redirect:/people";
        return "redirect:/people";
    }

    @ModelAttribute("headerMessage")
    public String populateHeaderMessage() {
        return "Welcome to our website";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        //Получим одного человека по его id из DAO и передадим на отображение в представление
        model.addAttribute("person", personDAO.show(id));
        return "people/edit"; //Этот метод будет отображать форму для редактирования одного человека
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()){
            return "people/edit";
        }
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
