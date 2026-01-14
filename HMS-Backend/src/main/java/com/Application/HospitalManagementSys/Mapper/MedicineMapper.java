package com.Application.HospitalManagementSys.Mapper;

import com.Application.HospitalManagementSys.DataTransferObject.MedicineDTO;
import com.Application.HospitalManagementSys.Entity.DocLogin.Medicine;

public class MedicineMapper {
    public static Medicine mapToMedicine(MedicineDTO medicineDTO) {

        Medicine medicine = new Medicine(
                medicineDTO.getId(),
                medicineDTO.getDrugName(),
                medicineDTO.getStock()
        );
        return medicine;
    }

    public static MedicineDTO mapToMedicineDTO(Medicine medicine) {

        MedicineDTO medicineDTO = new MedicineDTO(
                medicine.getId(),
                medicine.getDrugName(),
                medicine.getStock()
        );
        return medicineDTO;
    }
}
