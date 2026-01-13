package com.Application.HospitalManagementSys.Repo;

import com.Application.HospitalManagementSys.Entity.DocLogin.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Long> {
}
