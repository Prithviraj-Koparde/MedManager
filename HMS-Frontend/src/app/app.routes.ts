import { Routes } from '@angular/router';
import { AdmindashComponent } from './admindash/admindash.component';
import { AppointmentDashComponent } from './appointment-dash/appointment-dash.component';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';
import { HomePageComponent } from './home-page/home-page.component';
import { DoctorDashComponent } from './doctor-dash/doctor-dash.component';
import { CreatePatientComponent } from './create-patient/create-patient.component';
import { MedicineDashComponent } from './medicine-dash/medicine-dash.component';

export const routes: Routes = [
    { path: 'admin-dash', component: AdmindashComponent },
    { path: 'appointment-dash', component: AppointmentDashComponent },
    { path: 'add-appointment-dash', component: CreateAppointmentComponent },
    { path: 'home-page', component: HomePageComponent },
    { path: '', redirectTo: 'home-page', pathMatch: 'full' }, // to set the home page as default page
    { path: 'doc-dash', component: DoctorDashComponent },
    { path: 'add-patient-dash', component: CreatePatientComponent },
    { path: 'med-dash', component: MedicineDashComponent }
];
