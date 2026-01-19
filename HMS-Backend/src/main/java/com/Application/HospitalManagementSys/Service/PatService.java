package com.Application.HospitalManagementSys.Service;

import com.Application.HospitalManagementSys.DataTransferObject.PatientDTO;
import com.Application.HospitalManagementSys.ENUM.Gender;
import com.Application.HospitalManagementSys.ENUM.Urgency;
import com.Application.HospitalManagementSys.Entity.Patient;

import java.util.List;

public interface PatService {
    PatientDTO insertPatient(PatientDTO patientDTO);

    List<PatientDTO> getAllPatients();

    void deletePatientById(Long id);

    PatientDTO updatePatientById(PatientDTO patientDTO);

    PatientDTO getPatientById(Long id);

}
