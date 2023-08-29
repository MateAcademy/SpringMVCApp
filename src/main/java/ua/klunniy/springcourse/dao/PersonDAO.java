package ua.klunniy.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.klunniy.springcourse.enums.Gender;
import ua.klunniy.springcourse.models.Person;
import ua.klunniy.springcourse.utils.MyException;
import ua.klunniy.springcourse.utils.PersonComparatorById;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Serhii Klunniy
 */
@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
//    private static final String LOGIN = "postgres";
//    private static final String PASSWORD = "test";
//
//    private static final Connection connection;
//
//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


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
        //       return jdbcTemplate.query("SELECT * FROM Person ORDER BY id", new PersonMapper());
        return jdbcTemplate.query("SELECT * FROM Person ORDER BY id",
                new BeanPropertyRowMapper<>(Person.class));

//        String sql = "SELECT * FROM Person order by id";
//        try {
//        List<Person> people = new ArrayList<>();
//            Statement statement = connection.createStatement();
//
//            //executeQuery - он не изменяет данные в БД, он получает данные
//            ResultSet rs = statement.executeQuery(sql);
//
//            while (rs.next()) {
//                long id = rs.getLong("id");
//                int age = rs.getInt("age");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                Gender gender = Gender.valueOf(rs.getString("gender"));
//
//                Person person = new Person(id, age, name, email, gender);
//                people.add(person);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
// //       Collections.sort(people, new PersonComparatorById());
//        return people;
    }

    //второй метод возвращает одного человека
    public Person show(int id) {
//        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new PersonMapper())
//                .stream().findAny().orElse(null);

        return jdbcTemplate
                .query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
        //return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);

//        Person person = null;
//        try {
//            PreparedStatement ps =
//                    connection.prepareStatement("SELECT * FROM Person WHERE id=?");
//
//            ps.setLong(1, id);
//            //executeQuery - он не изменяет данные в БД, он получает данные
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                int age = rs.getInt("age");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                Gender gender = Gender.valueOf(rs.getString("gender"));
//                person = new Person(id, age, name, email, gender);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return person;
    }

    public void save(Person person) {
         jdbcTemplate.update("INSERT INTO Person(age, name, email, gender) values (?, ?, ?, ?::gender                                                                                                                                                       )",
                         person.getAge(), person.getName(), person.getEmail(), person.getGender().toString());

         //        if (person != null) {
//            String sql = "Insert into Person(age, name, email, gender) values (?, ?, ?, ?::gender)";
//            try {
//                PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setLong(1, person.getAge());
//                preparedStatement.setString(2, person.getName());
//                preparedStatement.setString(3, person.getEmail());
//                preparedStatement.setString(4, person.getGender().name());
//                //executeUpdate() -
//                preparedStatement.executeUpdate();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }

    public void update(int id, Person person) {
        jdbcTemplate.update("UPDATE Person SET age=?, name=?, email=?, gender=?::gender where id=?",
                person.getAge(), person.getName(), person.getEmail(), person.getGender().toString(), id);

//        Person personToBeUpdated = show(id);
//        personToBeUpdated.setName(updatePerson.getName());
//        personToBeUpdated.setSurname(updatePerson.getSurname());
//        personToBeUpdated.setEmail(updatePerson.getEmail());
//        personToBeUpdated.setAge(updatePerson.getAge());

//        if (updatePerson != null && id > 0) {
//            String sql = "UPDATE Person SET age=?, name=?, email=?, gender=?::gender where id=?";
//            try {
//                PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setLong(1, updatePerson.getAge());
//                preparedStatement.setString(2, updatePerson.getName());
//                preparedStatement.setString(3, updatePerson.getEmail());
//                preparedStatement.setString(4, updatePerson.getGender().name());
//                preparedStatement.setLong(5, id);
//                //executeUpdate() -
//                preparedStatement.executeUpdate();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person where id=?", id);

        //people.removeIf(p -> p.getId() == id);
//        Person person = null;
//        try {
//            PreparedStatement ps =
//                    connection.prepareStatement("DELETE FROM Person where id=?");
//            ps.setLong(1, id);
//            //executeQuery - он не изменяет данные в БД, он получает данные
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}
