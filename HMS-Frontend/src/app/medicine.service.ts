import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Medicine } from './medicine';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private httpClient: HttpClient) { }

  private baseUrl = "http://localhost:8080/api/medicine"

  getMedicineList(): Observable<Medicine[]> {
    return this.httpClient.get<Medicine[]>(`${this.baseUrl}`)
  }

  saveNewMedicine(medicine: Medicine): Observable<Medicine> {
    return this.httpClient.post<Medicine>(`${this.baseUrl}/create`, medicine)
  }

  deleteMedicineById(id: number): Observable<object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`)
  }

  updateMedicineById(id: number, medicine: Medicine): Observable<object> {
    return this.httpClient.put(`${this.baseUrl}/${id}`, medicine)
  }

  getMedicineById(id: number): Observable<Medicine> {
    return this.httpClient.get<Medicine>(`${this.baseUrl}/${id}`)
  }


  // pagination service logic
  getMedicinesList(page: number, pgSize: number): Observable<any> {
    return this.httpClient.get<any>(`${this.baseUrl}?page=${page}&pgSize${pgSize}`)
  }
}
