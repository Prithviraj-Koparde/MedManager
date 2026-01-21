import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Medicine } from '../medicine';
import { MedicineService } from '../medicine.service';

@Component({
  selector: 'app-update-medicine',
  imports: [RouterLink, FormsModule, CommonModule],
  templateUrl: './update-medicine.component.html',
  styleUrl: './update-medicine.component.css'
})
export class UpdateMedicineComponent {
  constructor(private medicineService: MedicineService, private router: Router, private route: ActivatedRoute) { }
  medicine: Medicine = new Medicine()
  id: number = 0

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']
    this.medicineService.getMedicineById(this.id).subscribe(data => {
      this.medicine = data
    })
  }

  onSubmit() {
    this.medicineService.updateMedicineById(this.id, this.medicine).subscribe(data => {
      console.log(data)
      this.goToMedicineList()
    })
  }

  goToMedicineList() {
    this.router.navigate(['med-dash'])
  }

}
