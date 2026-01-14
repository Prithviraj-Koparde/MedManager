package com.Application.HospitalManagementSys.Controller;

import com.Application.HospitalManagementSys.DataTransferObject.MedicineDTO;
import com.Application.HospitalManagementSys.Service.MedService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicine")
public class MedicineController {
    @Autowired
    private MedService medService;

    @PostMapping("create")
    public ResponseEntity<MedicineDTO> createMedicine(@Valid @RequestBody MedicineDTO medicineDTO){
        return new ResponseEntity<>(medService.insertMedicine(medicineDTO), HttpStatus.CREATED);
    }
}
