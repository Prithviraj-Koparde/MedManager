import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private httpClient: HttpClient) { }

  private baseURL = "http://localhost:8080/api/patient"

  getPatientList(): Observable<Patient[]> {

    return this.httpClient.get<Patient[]>(`${this.baseURL}`);
  }

  deletePatientById(id: number): Observable<object> {
    return this.httpClient.delete(`${this.baseURL}/${id}`)
  }

  saveNewPatient(patient: Patient): Observable<Patient> {
    return this.httpClient.post<Patient>(`${this.baseURL}/create`, patient)
  }

  updatePatientById(id: number, patient: Patient): Observable<object> {
    return this.httpClient.put(`${this.baseURL}/${id}`, patient)
  }

  getPatientById(id:number):Observable<Patient>{
    return this.httpClient.get<Patient>(`${this.baseURL}/${id}`)
  }
}
