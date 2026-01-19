import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Appointment } from '../appointment';
import { AppointmentService } from '../appointment.service';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-create-appointment',
  imports: [FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './create-appointment.component.html',
  styleUrl: './create-appointment.component.css'
})
export class CreateAppointmentComponent {

  appointment: Appointment = new Appointment();
  constructor(private appointmentService: AppointmentService, private router:Router) { }

  onSubmit() {
    this.saveAppointment()
  }

  saveAppointment() {
    this.appointmentService.saveNewAppointment(this.appointment).subscribe(data => {
      console.log(data);
      this.goToAppointmentList()
    })
  }

  goToAppointmentList(){
    this.router.navigate(['/appointment-dash'])
  }
}
