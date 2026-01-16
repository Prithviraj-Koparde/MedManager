package com.Application.HospitalManagementSys.Controller;

import com.Application.HospitalManagementSys.DataTransferObject.AppointmentDTO;
import com.Application.HospitalManagementSys.Service.IMPL.AppointmentServiceIMPL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    @Autowired
    AppointmentServiceIMPL appointmentService;

    @PostMapping("create")
    public ResponseEntity<AppointmentDTO> createAppointment (@Valid @RequestBody AppointmentDTO appointmentDTO){
        return new ResponseEntity<>(appointmentService.insertAppointment(appointmentDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments (){
        List<AppointmentDTO> appointmentDTOS = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointmentDTOS);
    }
}
