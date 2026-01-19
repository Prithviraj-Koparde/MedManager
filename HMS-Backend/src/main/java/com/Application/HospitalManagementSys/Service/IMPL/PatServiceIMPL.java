package com.Application.HospitalManagementSys.Service.IMPL;

import com.Application.HospitalManagementSys.DataTransferObject.PatientDTO;
import com.Application.HospitalManagementSys.ENUM.Gender;
import com.Application.HospitalManagementSys.ENUM.Urgency;
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

    @Override
    public PatientDTO updatePatientById(PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(patientDTO.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Patient not found with id " + patientDTO.getId()
                ));

        patient.setName(patientDTO.getName());
        patient.setContactNumber(patientDTO.getContactNumber());
        patient.setAge(patientDTO.getAge());
        patient.setGender(patientDTO.getGender());
        patient.setBloodGroup(patientDTO.getBloodGroup());
        patient.setDose(patientDTO.getDose());
        patient.setPrescription(patientDTO.getPrescription());
        patient.setUrgency(patientDTO.getUrgency());
        patient.setFees(patientDTO.getFees());

        return PatientMapper.mapToPatientDTO(patientRepository.save(patient));
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        if (!patientRepository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Patient with id not found" + " " + id
            );
        }
        Patient patient = patientRepository.getReferenceById(id);
        return PatientMapper.mapToPatientDTO(patient);
    }


}
