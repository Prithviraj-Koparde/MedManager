package com.Application.HospitalManagementSys.Mapper;

import com.Application.HospitalManagementSys.DataTransferObject.AppointmentDTO;
import com.Application.HospitalManagementSys.Entity.DocLogin.Appointment;

public class AppointmentMapper {
    public static Appointment mapToAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment(
                appointmentDTO.getName(),
                appointmentDTO.getAge(),
                appointmentDTO.getSymptoms(),
                appointmentDTO.getContactNumber()
        );
        return appointment;
    }

    public static AppointmentDTO mapToAppointmentDTO(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO(
                appointment.getId(),
                appointment.getName(),
                appointment.getAge(),
                appointment.getSymptoms(),
                appointment.getContactNumber()
        );
        return appointmentDTO;
    }
}
