package ua.klunniy.springcourse.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Serhii Klunniy
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private int id;
    private String name;

}
