package com.Application.HospitalManagementSys.Service.IMPL;

import com.Application.HospitalManagementSys.DataTransferObject.MedicineDTO;
import com.Application.HospitalManagementSys.Entity.DocLogin.Medicine;
import com.Application.HospitalManagementSys.Mapper.MedicineMapper;
import com.Application.HospitalManagementSys.Repo.MedicineRepository;
import com.Application.HospitalManagementSys.Service.MedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @Override
    public List<MedicineDTO> getAllMedicine() {
        return medicineRepository.findAll().stream().map(MedicineMapper::mapToMedicineDTO).toList();
    }

    @Override
    public void deleteMedicineById(Long id) {
        if (!medicineRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Medicine with id doesn't exist to delete" + " " + id
            );
        }
        medicineRepository.deleteById(id);
    }

    @Override
    public MedicineDTO updateMedicineById(MedicineDTO medicineDTO) {
        Medicine medicine = medicineRepository.findById(medicineDTO.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Medicine not found with id" + " " + medicineDTO.getId()
                ));

        medicine.setDrugName(medicineDTO.getDrugName());
        medicine.setStock(medicineDTO.getStock());

        return MedicineMapper.mapToMedicineDTO(medicineRepository.save(medicine));
    }

    @Override
    public MedicineDTO getMedicineById(Long id) {
        if (!medicineRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Medicine with id not found!" + " " + id
            );
        }
        Medicine medicine = medicineRepository.getReferenceById(id);
        return MedicineMapper.mapToMedicineDTO(medicine);
    }


}
