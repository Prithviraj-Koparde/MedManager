package com.Application.HospitalManagementSys.Controller;

import com.Application.HospitalManagementSys.Repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;
}
