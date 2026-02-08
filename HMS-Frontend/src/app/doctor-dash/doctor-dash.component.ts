import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { authService } from '../auth.service';

@Component({
  selector: 'app-doctor-dash',
  imports: [CommonModule, FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './doctor-dash.component.html',
  styleUrl: './doctor-dash.component.css'
})
export class DoctorDashComponent {
  constructor(private patientService: PatientService, private authService:authService, private router: Router) { }
  ngOnInit(): void {
    this.docGetAllPatients()
  }
  patients: Patient[] = []


  docGetAllPatients() {
    this.patientService.getPatientList().subscribe(data => {
      this.patients = data;
      console.log(this.patients);
    })
  }

  deletePatientById(id:number){
    this.patientService.deletePatientById(id).subscribe(data=>{
      console.log(data)
      this.docGetAllPatients()
    })
  }

  update(id:number){
    this.router.navigate(['update-patient',id])
  }

  viewPatientById(id:number){
    this.router.navigate(['patient-card',id])
  }

  logOut(){
    this.authService.logOut()
    this.router.navigate(['home-page'])
  }
}
