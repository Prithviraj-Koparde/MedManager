package com.Application.HospitalManagementSys.Controller;

import com.Application.HospitalManagementSys.DataTransferObject.AppointmentDTO;
import com.Application.HospitalManagementSys.Service.IMPL.AppointmentServiceIMPL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    @Autowired
    AppointmentServiceIMPL appointmentService;

    @PostMapping("create")
    public ResponseEntity<AppointmentDTO> createAppointment (@Valid @RequestBody AppointmentDTO appointmentDTO){
        return new ResponseEntity<>(appointmentService.insertAppointment(appointmentDTO), HttpStatus.CREATED);
    }
}
