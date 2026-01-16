import { Component } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Appointment } from '../appointment';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-appointment-dash',
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './appointment-dash.component.html',
  styleUrl: './appointment-dash.component.css'
})
export class AppointmentDashComponent {
  constructor(private appointmentService: AppointmentService) { }
  ngOnInit(): void {
    this.getAppointments();
  }
  appointments: Appointment[] = [];

  getAppointments() {
    this.appointmentService.getAppointmentList().subscribe(data => {
      this.appointments = data;
      console.log(this.appointments)
    })
  }
}
