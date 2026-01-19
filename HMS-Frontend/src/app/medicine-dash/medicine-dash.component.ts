import { Component } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { Medicine } from '../medicine';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-medicine-dash',
  imports: [FormsModule, CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './medicine-dash.component.html',
  styleUrl: './medicine-dash.component.css'
})
export class MedicineDashComponent {
  medicines: Medicine[] = []
  constructor(private medicineService: MedicineService) { }

  ngOnInit():void{
    this.getAllMedicines()
  }

  getAllMedicines() {
    this.medicineService.getMedicineList().subscribe(data => {
      this.medicines = data;
      console.log(data)
    })
  }

  deleteMedicineById(id: number) {
    this.medicineService.deleteMedicineById(id).subscribe(data => {
      this.getAllMedicines()
      console.log(data)
    })
  }
}
