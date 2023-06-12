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
    String firstName;
    String lastName;
    String email;
    Gender gender;

    public Person(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }
}
