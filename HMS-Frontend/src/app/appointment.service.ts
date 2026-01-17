import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  constructor(private httpClient: HttpClient) { }

  private baseUrl = "http://localhost:8080/api/appointment"

  getAppointmentList(): Observable<Appointment[]> {
    return this.httpClient.get<Appointment[]>(`${this.baseUrl}`)
  }

  saveNewAppointment(appointment: Appointment): Observable<Appointment> {
    return this.httpClient.post<Appointment>(`${this.baseUrl}/create`, appointment)
  }

  deleteAppointmentById(id: number): Observable<object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`)
  }
}
