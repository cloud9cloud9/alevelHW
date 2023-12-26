package ua.nalezhytyi.hw20.task4;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.nalezhytyi.hw20.task4.Address;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @Embedded
    private Address address;
}

