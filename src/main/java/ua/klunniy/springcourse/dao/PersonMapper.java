package ua.klunniy.springcourse.dao;


import org.springframework.jdbc.core.RowMapper;
import ua.klunniy.springcourse.enums.Gender;
import ua.klunniy.springcourse.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Serhii Klunniy
 */
public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();

        person.setId(rs.getLong("id"));
        person.setAge(rs.getInt("age"));
        person.setName(rs.getString("name"));
        person.setEmail(rs.getString("email"));
        person.setGender(Gender.valueOf(rs.getString("gender")));

        return person;
    }
}
