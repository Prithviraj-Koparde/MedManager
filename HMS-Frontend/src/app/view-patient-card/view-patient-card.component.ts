import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { UpdatePatientComponent } from '../update-patient/update-patient.component';
import { DoctorDashComponent } from '../doctor-dash/doctor-dash.component';

@Component({
  selector: 'app-view-patient-card',
  imports: [CommonModule, RouterLink],
  templateUrl: './view-patient-card.component.html',
  styleUrl: './view-patient-card.component.css'
})
export class ViewPatientCardComponent {
  constructor(private patientService: PatientService, private route: ActivatedRoute, private router: Router) { }

  patient: Patient = new Patient()
  id: number = 0

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']
    this.patientService.getPatientById(this.id).subscribe(data => {
      this.patient = data
      console.log(this.patient)
    })
  }

  goBack() {
    this.router.navigate(['doc-dash'])
  }

  deletePatientCardById(id:number){
    this.patientService.deletePatientById(id).subscribe(data=>{
      console.log(data)
      this.goBack()
    })
  }

}