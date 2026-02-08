import { Component } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Appointment } from '../appointment';
import { CommonModule } from '@angular/common';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { authService } from '../auth.service';

@Component({
  selector: 'app-appointment-dash',
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './appointment-dash.component.html',
  styleUrl: './appointment-dash.component.css'
})
export class AppointmentDashComponent {
  constructor(private appointmentService: AppointmentService, private authService: authService, private router: Router) { }
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

  delete(id: number) {
    this.appointmentService.deleteAppointmentById(id).subscribe(data => {
      console.log(data)
      this.getAppointments()            //redirect to this.getAppointments() after delete otherwise still on same page
    })
  }

  logOut() {
    this.authService.logOut()
    this.router.navigate(['home-page'])
  }
}
