import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-create-patient',
  imports: [RouterLink, FormsModule],
  templateUrl: './create-patient.component.html',
  styleUrl: './create-patient.component.css'
})
export class CreatePatientComponent {
  constructor(private patientService: PatientService, private router: Router) { }
  patient: Patient = new Patient

  onSubmit(){
    this.savePatient()
  }


  savePatient() {
    this.patientService.saveNewPatient(this.patient).subscribe(data => {
      this.patient = data;
      console.log(this.patient)
      this.goToDocDash()
    })
  }

  goToDocDash() {
    this.router.navigate(['/doc-dash'])
  }
}
