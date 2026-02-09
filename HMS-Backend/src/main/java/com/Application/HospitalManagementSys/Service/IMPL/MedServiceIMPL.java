package com.Application.HospitalManagementSys.Service.IMPL;

import com.Application.HospitalManagementSys.DataTransferObject.MedicineDTO;
import com.Application.HospitalManagementSys.Entity.DocLogin.Medicine;
import com.Application.HospitalManagementSys.Mapper.MedicineMapper;
import com.Application.HospitalManagementSys.Repo.MedicineRepository;
import com.Application.HospitalManagementSys.Service.MedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    public List<MedicineDTO> saveAllMedicines(List<MedicineDTO> medicineDTOList) {
        if (medicineDTOList == null || medicineDTOList.isEmpty()) {
            throw new IllegalArgumentException("Medicine list cannot be empty!");
        }

        Map<String, MedicineDTO> uniqueMedicines = new LinkedHashMap<>();

        for (MedicineDTO medicineDTO : medicineDTOList) {
            uniqueMedicines.put(medicineDTO.getDrugName(), medicineDTO);
        }

        List<Medicine> medicines = medicineRepository.saveAll(medicineDTOList.stream().map(MedicineMapper::mapToMedicine).toList());

        return medicines.stream().map(MedicineMapper::mapToMedicineDTO).toList();
    }

//    @Override
//    public List<MedicineDTO> getAllMedicine() {
//        return medicineRepository.findAll().stream().map(MedicineMapper::mapToMedicineDTO).toList();
//    }

    @Override
    public void deleteMedicineById(Long id) {
        if (!medicineRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicine with id doesn't exist to delete" + " " + id);
        }
        medicineRepository.deleteById(id);
    }

    @Override
    public MedicineDTO updateMedicineById(MedicineDTO medicineDTO) {
        Medicine medicine = medicineRepository.findById(medicineDTO.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicine not found with id" + " " + medicineDTO.getId()));

        medicine.setDrugName(medicineDTO.getDrugName());
        medicine.setStock(medicineDTO.getStock());

        return MedicineMapper.mapToMedicineDTO(medicineRepository.save(medicine));
    }

    @Override
    public MedicineDTO getMedicineById(Long id) {
        if (!medicineRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicine with id not found!" + " " + id);
        }
        Medicine medicine = medicineRepository.getReferenceById(id);
        return MedicineMapper.mapToMedicineDTO(medicine);
    }

    @Override
    public Page<MedicineDTO> getAllMedicines(int page, int pgSize) {

        Pageable pageable = PageRequest.of(page, pgSize);
        Page<Medicine> medicinePage = medicineRepository.findAll(pageable);
        return medicinePage.map(MedicineMapper::mapToMedicineDTO);

    }


}
