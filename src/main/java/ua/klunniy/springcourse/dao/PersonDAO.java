package ua.klunniy.springcourse.dao;

import org.springframework.stereotype.Component;
import ua.klunniy.springcourse.enums.Gender;
import ua.klunniy.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serhii Klunniy
 */
@Component
public class PersonDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/shop";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "test";

    private static final Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //      private static int PEOPLE_COUNT;
    //      private static final Logger logger = Logger.getLogger(DbConnector.class);
    //      private static List<Person> people;

//    {
//        people = new ArrayList<>();
//        people.add(new Person(++PEOPLE_COUNT, 24, "Tom"));
//        people.add(new Person(++PEOPLE_COUNT, 34, "Bob"));
//        people.add(new Person(++PEOPLE_COUNT, 44, "Mike"));
//        people.add(new Person(++PEOPLE_COUNT, 54, "Kate"));
//    }

    //в этом методе мы просто возвращаем список из людей
    public List<Person> index() {

        List<Person> people = new ArrayList<>();
        String sql = "SELECT * FROM Person";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                long id = rs.getLong("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Gender gender = Gender.valueOf(rs.getString("gender"));

                Person person = new Person(id, age, name, email, gender);
                people.add(person);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return people;
    }

    //второй метод возвращает одного человека
    public Person show(int id) {
        //return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return null;
    }

    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        System.out.println(personDAO.show(2));
    }

    public static void save(Person person) {
//        if (person != null) {
//            person.setId(++PEOPLE_COUNT);
//            people.add(person);
//        }
    }

    public void update(int id, Person updatePerson) {
//        Person personToBeUpdated = show(id);
//        personToBeUpdated.setName(updatePerson.getName());
//        personToBeUpdated.setSurname(updatePerson.getSurname());
//        personToBeUpdated.setEmail(updatePerson.getEmail());
//        personToBeUpdated.setAge(updatePerson.getAge());
    }

    public void delete(int id) {
        //people.removeIf(p -> p.getId() == id);
    }
}
