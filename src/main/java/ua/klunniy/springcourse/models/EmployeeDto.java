package ua.klunniy.springcourse.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ua.klunniy.springcourse.enums.Gender;

/**
 * @author Serhii Klunniy
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {

    String firstName;
    String lastName;
    String email;
    Gender gender;

    public String getFullName() {return firstName.concat(" ").concat(lastName);}

   // public boolean isMan() {return Gender.MALE.equals(gender);}

}
