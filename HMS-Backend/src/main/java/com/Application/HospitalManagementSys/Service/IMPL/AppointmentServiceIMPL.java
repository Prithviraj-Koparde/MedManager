package com.Application.HospitalManagementSys.Service.IMPL;

import com.Application.HospitalManagementSys.DataTransferObject.AppointmentDTO;
import com.Application.HospitalManagementSys.Entity.DocLogin.Appointment;
import com.Application.HospitalManagementSys.Mapper.AppointmentMapper;
import com.Application.HospitalManagementSys.Repo.AppointmentRepository;
import com.Application.HospitalManagementSys.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceIMPL implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public AppointmentDTO insertAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = AppointmentMapper.mapToAppointment(appointmentDTO);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return AppointmentMapper.mapToAppointmentDTO(savedAppointment);
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll().stream().map(AppointmentMapper::mapToAppointmentDTO).toList();
    }
}
