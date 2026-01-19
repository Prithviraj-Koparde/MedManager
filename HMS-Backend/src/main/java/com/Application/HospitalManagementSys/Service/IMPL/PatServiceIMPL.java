package com.Application.HospitalManagementSys.Service.IMPL;

import com.Application.HospitalManagementSys.DataTransferObject.PatientDTO;
import com.Application.HospitalManagementSys.Entity.Patient;
import com.Application.HospitalManagementSys.Mapper.PatientMapper;
import com.Application.HospitalManagementSys.Repo.PatientRepository;
import com.Application.HospitalManagementSys.Service.PatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PatServiceIMPL implements PatService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientDTO insertPatient(PatientDTO patientDTO) {
        Patient patient = PatientMapper.mapToPatient(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return PatientMapper.mapToPatientDTO(savedPatient);
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll().stream().map(PatientMapper::mapToPatientDTO).toList();
    }

    @Override
    public void deletePatientById(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient with id doesn't exist to delete" + " " + id);
        }
        patientRepository.deleteById(id);
    }

}
