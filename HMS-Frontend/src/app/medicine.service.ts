import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Medicine } from './medicine';

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
}
