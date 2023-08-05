package ua.klunniy.springcourse.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
    @Min(value = 0, message = "age should be greater then 0")
    int age;

    @NotEmpty(message = "Name should not be empty") //не может быть нулл и не может быть пустое сообщение
    @Size(min = 2, max = 10, message = "Name should be 2 and 10 characters")
    String name;
    String surname;
    String lastName;

    @NotEmpty(message = "Email should not be empty") //не может быть нулл и не может быть пустое сообщение
    @Email(message = "Email should be valid")
    String email;
    Gender gender;

    public Person(int id, int age, String name) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
