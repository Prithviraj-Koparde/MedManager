package com.Application.HospitalManagementSys.Controller;

import com.Application.HospitalManagementSys.DataTransferObject.MedicineDTO;
import com.Application.HospitalManagementSys.Service.MedService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineController {
    @Autowired
    private MedService medService;

    @PostMapping("create")
    public ResponseEntity<MedicineDTO> createMedicine(@Valid @RequestBody MedicineDTO medicineDTO) {
        return new ResponseEntity<>(medService.insertMedicine(medicineDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicineDTO>> getAllMedicines() {
        List<MedicineDTO> medicineDTOS = medService.getAllMedicine();
        return ResponseEntity.ok(medicineDTOS);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMedicineById(@PathVariable Long id) {
        medService.deleteMedicineById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<MedicineDTO> updateMedicineById(
            @PathVariable Long id,
            @RequestBody MedicineDTO medicineDTO
    ) {
        medicineDTO.setId(id);
        return ResponseEntity.ok(medService.updateMedicineById(medicineDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<MedicineDTO> getMedicineById(@PathVariable Long id) {
        MedicineDTO medicineDTO = medService.getMedicineById(id);
        return ResponseEntity.ok(medicineDTO);
    }
}