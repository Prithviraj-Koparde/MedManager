import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { FormsModule } from "@angular/forms";
import { ActivatedRoute, Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-update-patient',
  imports: [FormsModule, RouterLink],
  templateUrl: './update-patient.component.html',
  styleUrl: './update-patient.component.css'
})
export class UpdatePatientComponent {
  constructor(private patientService: PatientService, private router: Router, private route: ActivatedRoute) { }

  patient: Patient = new Patient()
  id: number = 0

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']
    this.patientService.getPatientById(this.id).subscribe(data => {
      this.patient = data
    })
  } 
  onSubmit() {
    this.patientService.updatePatientById(this.id, this.patient).subscribe(data => {
      console.log(data)
      this.goToDocDash()
    })
  }

  goToDocDash() {
    this.router.navigate(['doc-dash'])
  }

}
