package ua.klunniy.springcourse.utils;

import ua.klunniy.springcourse.models.Person;

import java.util.Comparator;

/**
 * @author Serhii Klunniy
 */
public class PersonComparatorById implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return (int)(o1.getId() - o2.getId());
    }
}
