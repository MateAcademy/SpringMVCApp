package ua.klunniy.springcourse.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ua.klunniy.springcourse.enums.Gender;

/**
 * @author Serhii Klunniy
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {

    int id;
    String name;
    String surname;
    String lastName;
    String email;
    Gender gender;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
