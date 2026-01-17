import { Routes } from '@angular/router';
import { AdmindashComponent } from './admindash/admindash.component';
import { AppointmentDashComponent } from './appointment-dash/appointment-dash.component';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';

export const routes: Routes = [
    { path: 'admin-dash', component: AdmindashComponent },
    { path: 'appointment-dash', component: AppointmentDashComponent },
    { path: 'add-appointment-dash', component: CreateAppointmentComponent }
];
