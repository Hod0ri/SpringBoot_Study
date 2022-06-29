package com.amigoscode.jpabasic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(
        name = "student",
        uniqueConstraints = @UniqueConstraint(
                name = "student_email_unique",
                columnNames = "email"
        )
)
public class Student {
    @Id
    @SequenceGenerator(
            name="student_seq",
            sequenceName="student_seq",
            allocationSize=1
    )
    @GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "student_seq")
    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @Column(
            name="first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstname;

    @Column(
            name="last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastname;

    @Column(
            name="email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(name="age")
    private Integer age;

    public Student(String firstname, String lastname, String email, Integer age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }
}
