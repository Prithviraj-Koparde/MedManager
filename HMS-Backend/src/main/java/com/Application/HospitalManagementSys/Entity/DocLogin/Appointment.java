package com.Application.HospitalManagementSys.Entity.DocLogin;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "contactNumber")
    private String contactNumber;

    // cons without id
    public Appointment(String name, Integer age, String symptoms, String contactNumber) {
        this.name = name;
        this.age = age;
        this.symptoms = symptoms;
        this.contactNumber = contactNumber;
    }


}
