import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admindash',
  imports: [CommonModule],
  templateUrl: './admindash.component.html',
  styleUrl: './admindash.component.css'
})
export class AdmindashComponent {

  constructor(private patientService: PatientService) { }
  ngOnInit(): void {
    this.getPatients();
  }
  patients: Patient[] = [];

  getPatients() {
    this.patientService.getPatientList().subscribe(data => {
      this.patients = data;
    })
  }
}
