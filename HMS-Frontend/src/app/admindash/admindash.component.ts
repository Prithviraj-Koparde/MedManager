import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { FormsModule } from "@angular/forms";

@Component({
  selector: 'app-admindash',
  imports: [CommonModule, RouterLink, RouterLinkActive, FormsModule],
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
      console.log(this.patients)
    })
  }

  deletePatientById(id:number){
    this.patientService.deletePatientById(id).subscribe(data=>{
      console.log(data);
      this.getPatients();
    })
  }
}
