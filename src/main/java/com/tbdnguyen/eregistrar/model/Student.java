package com.tbdnguyen.eregistrar.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author duong at 7/2/21
 * @project eRegistrar
 */
@Entity()
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

    @NotNull(message = "Enrollment date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;

    private Boolean isInternation = false;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa=" + cgpa +
                ", enrollmentDate=" + enrollmentDate +
                ", isInternation=" + isInternation +
                '}';
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public String getEnrollmentDateString() {
        if (this.enrollmentDate != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-YYYY");
            return formatter.format(this.enrollmentDate);
        }
        return null;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Boolean getInternation() {
        return isInternation;
    }

    public void setInternation(Boolean internation) {
        isInternation = internation;
    }
}
