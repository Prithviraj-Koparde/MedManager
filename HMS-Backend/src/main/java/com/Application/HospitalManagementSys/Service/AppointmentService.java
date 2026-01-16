package com.Application.HospitalManagementSys.Service;

import com.Application.HospitalManagementSys.DataTransferObject.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    AppointmentDTO insertAppointment (AppointmentDTO appointmentDTO);
    List<AppointmentDTO> getAllAppointments();
}
