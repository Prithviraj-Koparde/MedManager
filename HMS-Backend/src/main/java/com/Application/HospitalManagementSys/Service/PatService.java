package com.Application.HospitalManagementSys.Service;

import com.Application.HospitalManagementSys.DataTransferObject.PatientDTO;

import java.util.List;

public interface PatService {
    PatientDTO insertPatient (PatientDTO patientDTO);
    List<PatientDTO> getAllPatients ();
    void deletePatientById(Long id);
}
