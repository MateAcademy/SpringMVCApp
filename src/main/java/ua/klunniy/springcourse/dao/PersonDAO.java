package ua.klunniy.springcourse.dao;

import org.springframework.stereotype.Component;
import ua.klunniy.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Serhii Klunniy
 */
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, 24, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, 34, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, 44, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, 54, "Kate"));
    }

    //в этом методе мы просто возвращаем список из людей
    public List<Person> index() {
        return people;
    }

    //второй метод возвращает одного человека
    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        System.out.println(personDAO.show(2));
    }

    public static void save(Person person) {
        if (person != null) {
            person.setId(++PEOPLE_COUNT);
            people.add(person);
        }
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setSurname(updatePerson.getSurname());
        personToBeUpdated.setEmail(updatePerson.getEmail());
        personToBeUpdated.setAge(updatePerson.getAge());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
