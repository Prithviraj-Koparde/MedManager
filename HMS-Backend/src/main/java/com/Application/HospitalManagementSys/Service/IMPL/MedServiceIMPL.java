package com.Application.HospitalManagementSys.Service.IMPL;

import com.Application.HospitalManagementSys.DataTransferObject.MedicineDTO;
import com.Application.HospitalManagementSys.Entity.DocLogin.Medicine;
import com.Application.HospitalManagementSys.Mapper.MedicineMapper;
import com.Application.HospitalManagementSys.Repo.MedicineRepository;
import com.Application.HospitalManagementSys.Service.MedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedServiceIMPL implements MedService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public MedicineDTO insertMedicine(MedicineDTO medicineDTO) {
        Medicine medicine = MedicineMapper.mapToMedicine(medicineDTO);
        Medicine savedMedicine = medicineRepository.save(medicine);
        return MedicineMapper.mapToMedicineDTO(savedMedicine);
    }
}
