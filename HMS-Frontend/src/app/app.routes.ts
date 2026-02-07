import { Routes } from '@angular/router';
import { AdmindashComponent } from './admindash/admindash.component';
import { AppointmentDashComponent } from './appointment-dash/appointment-dash.component';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';
import { HomePageComponent } from './home-page/home-page.component';
import { DoctorDashComponent } from './doctor-dash/doctor-dash.component';
import { CreatePatientComponent } from './create-patient/create-patient.component';
import { MedicineDashComponent } from './medicine-dash/medicine-dash.component';
import { AddMedicineComponent } from './add-medicine/add-medicine.component';
import { UpdatePatientComponent } from './update-patient/update-patient.component';
import { ViewPatientCardComponent } from './view-patient-card/view-patient-card.component';
import { UpdateMedicineComponent } from './update-medicine/update-medicine.component';
import { DocLoginComponent } from './doc-login/doc-login.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';

export const routes: Routes = [
    { path: 'admin-dash', component: AdmindashComponent },
    { path: 'appointment-dash', component: AppointmentDashComponent },
    { path: 'add-appointment-dash', component: CreateAppointmentComponent },
    { path: 'home-page', component: HomePageComponent },
    { path: '', redirectTo: 'home-page', pathMatch: 'full' }, // to set the home page as default page
    { path: 'doc-dash', component: DoctorDashComponent },
    { path: 'add-patient-dash', component: CreatePatientComponent },
    { path: 'med-dash', component: MedicineDashComponent },
    { path: 'add-medicine-dash', component: AddMedicineComponent },
    { path: 'update-patient/:id', component: UpdatePatientComponent }, // to go in patient with its id
    { path: 'patient-card/:id', component: ViewPatientCardComponent },
    { path: 'update-medicine/:id', component: UpdateMedicineComponent }, // to go in medicine with its id
    { path: 'doc-login', component: DocLoginComponent },
    { path: 'admin-login', component: AdminLoginComponent }
];
