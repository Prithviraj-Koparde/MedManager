package com.Application.HospitalManagementSys.Repo;

import com.Application.HospitalManagementSys.Entity.DocLogin.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
