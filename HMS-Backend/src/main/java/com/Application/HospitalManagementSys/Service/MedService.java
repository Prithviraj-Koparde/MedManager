package com.Application.HospitalManagementSys.Service;

import com.Application.HospitalManagementSys.DataTransferObject.MedicineDTO;

import java.util.List;

public interface MedService {
    MedicineDTO insertMedicine(MedicineDTO medicineDTO);
    List<MedicineDTO> getAllMedicine();
    void deleteMedicineById(Long id);
}
