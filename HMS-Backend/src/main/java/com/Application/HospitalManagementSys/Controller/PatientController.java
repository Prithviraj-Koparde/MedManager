package com.Application.HospitalManagementSys.Controller;

import com.Application.HospitalManagementSys.DataTransferObject.PatientDTO;
import com.Application.HospitalManagementSys.Repo.PatientRepository;
import com.Application.HospitalManagementSys.Service.PatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    @Autowired
    private PatService patService;

    @PostMapping("create")
    public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody PatientDTO patientDTO){
        return new ResponseEntity<>(patService.insertPatient(patientDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients(){
        List<PatientDTO> patientDTOs = patService.getAllPatients();
        return ResponseEntity.ok(patientDTOs);
    }


}
