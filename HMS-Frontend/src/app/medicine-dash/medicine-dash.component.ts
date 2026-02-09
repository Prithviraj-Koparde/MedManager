import { Component } from '@angular/core';
import { MedicineService } from '../medicine.service';
import { Medicine } from '../medicine';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-medicine-dash',
  imports: [FormsModule, CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './medicine-dash.component.html',
  styleUrl: './medicine-dash.component.css'
})
export class MedicineDashComponent {
  medicines: Medicine[] = []
  currentPage = 0
  totalPages = 0
  pgSize = 0

  constructor(private medicineService: MedicineService, private router: Router) { }

  ngOnInit(): void {
    // this.getAllMedicines()
    this.getMedicinesList()
  }

  getAllMedicines() {
    this.medicineService.getMedicineList().subscribe(data => {
      this.medicines = data;
      console.log(data)
    })
  }

  deleteMedicineById(id: number) {
    this.medicineService.deleteMedicineById(id).subscribe(data => {
      this.getMedicinesList()
      console.log(data)
    })
  }

  updateMedicineById(id: number) {
    this.router.navigate(['update-medicine', id])
  }

  getMedicinesList() {
    this.medicineService.getMedicinesList(this.currentPage, this.pgSize).subscribe(data => {
      this.medicines = data.content   // because in backend it returns spring page<T> not plain list check on postman it will show content in which data is shown that we have to save here in medicines list
      this.totalPages = data.totalPages
    })
  }

  nextPage() {
    if (this.currentPage < this.totalPages - 1) {
      this.currentPage++
      this.getMedicinesList()
    }
  }

  prevPage() {
    if (this.currentPage > 0) {
      this.currentPage--
      this.getMedicinesList()
    }
  }
}
