package com.Application.HospitalManagementSys.Service;

import com.Application.HospitalManagementSys.DataTransferObject.MedicineDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MedService {
    MedicineDTO insertMedicine(MedicineDTO medicineDTO);

//    List<MedicineDTO> getAllMedicine();

    List<MedicineDTO> saveAllMedicines(List<MedicineDTO> medicineDTOList);

    void deleteMedicineById(Long id);

    MedicineDTO updateMedicineById(MedicineDTO medicineDTO);

    MedicineDTO getMedicineById(Long id);

    Page<MedicineDTO> getAllMedicines(int page, int pgSize);
}
