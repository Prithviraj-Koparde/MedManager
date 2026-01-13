package com.Application.HospitalManagementSys.Mapper;

import com.Application.HospitalManagementSys.DataTransferObject.PatientDTO;
import com.Application.HospitalManagementSys.Entity.Patient;

public class PatientMapper {
    public static Patient mapToPatient(PatientDTO patientDTO) {

        Patient patient = new Patient(
                patientDTO.getId(),
                patientDTO.getName(),
                patientDTO.getContactNumber(),
                patientDTO.getAge(),
                patientDTO.getGender(),
                patientDTO.getBloodGroup(),
                patientDTO.getDose(),
                patientDTO.getPrescription(),
                patientDTO.getUrgency(),
                patientDTO.getFees()
        );

        return patient;
    }

    public static PatientDTO mapToPatientDTO(Patient patient) {

        PatientDTO patientDTO = new PatientDTO(
                patient.getPatientId(),
                patient.getName(),
                patient.getContactNumber(),
                patient.getAge(),
                patient.getGender(),
                patient.getBloodGroup(),
                patient.getDose(),
                patient.getPrescription(),
                patient.getUrgency(),
                patient.getFees()
        );
        return patientDTO;
    }
}
