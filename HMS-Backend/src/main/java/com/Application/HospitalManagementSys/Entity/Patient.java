package com.Application.HospitalManagementSys.Entity;

import com.Application.HospitalManagementSys.ENUM.Gender;
import com.Application.HospitalManagementSys.ENUM.Urgency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;

    // ---------------- Personal Details ----------------

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "contact_number", nullable = false)
    private String contactNumber;

    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "blood_group")
    private String bloodGroup;

    // ---------------- Medical Details ----------------

    @Column(name = "dose")
    private String dose;

    @Column(name = "prescription")
    private String prescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "urgency")
    private Urgency urgency;

    // ---------------- Billing ----------------

    @Column(name = "fees")
    private Double fees;


    public Patient(String name, String contactNumber, Integer age, Gender gender, String bloodGroup, String dose, String prescription, Urgency urgency, Double fees) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.age = age;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.dose = dose;
        this.prescription = prescription;
        this.urgency = urgency;
        this.fees = fees;
    }

}
