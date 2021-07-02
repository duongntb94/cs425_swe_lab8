package com.tbdnguyen.eregistrar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * @author duong at 7/2/21
 * @project eRegistrar
 */
@Entity()
@Getter()
@Setter()
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotBlank(message = "Student number is required")
    @Column(unique = true)
    private String studentNumber;

    @NotBlank(message = "First name is required")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Min(value = 0)
    private Double cgpa;

    @NotBlank(message = "Enrollment date is required")
    private LocalDate enrollmentDate;

    @NotBlank(message = "Is internation is required")
    private Boolean isInternation;
}
