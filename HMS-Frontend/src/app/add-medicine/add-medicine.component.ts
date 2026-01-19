import { Component } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { Medicine } from '../medicine';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-medicine',
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './add-medicine.component.html',
  styleUrl: './add-medicine.component.css'
})
export class AddMedicineComponent {
  medicine: Medicine = new Medicine();
  constructor(private medicineService: MedicineService, private router: Router) { }

  onSubmit() {
    this.saveMedicine()
  }

  saveMedicine() {
    this.medicineService.saveNewMedicine(this.medicine).subscribe(data => {
      this.medicine = data;
      console.log(this.medicine);
      this.goToMedicineList()
    })
  }

  goToMedicineList() {
    this.router.navigate(['/med-dash']);
  }
}
