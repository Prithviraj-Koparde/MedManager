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
import { AdminAuthGuardService } from './admin-auth-guard.service';
import { DoctorAuthGuardService } from './doctor-auth-guard.service';

export const routes: Routes = [
    { path: 'admin-dash', component: AdmindashComponent, canActivate: [AdminAuthGuardService] },
    { path: 'appointment-dash', component: AppointmentDashComponent, canActivate: [AdminAuthGuardService] },
    { path: 'add-appointment-dash', component: CreateAppointmentComponent, canActivate: [AdminAuthGuardService] },
    { path: 'home-page', component: HomePageComponent },
    { path: '', redirectTo: 'home-page', pathMatch: 'full' }, // to set the home page as default page
    { path: 'doc-dash', component: DoctorDashComponent, canActivate: [DoctorAuthGuardService] },
    { path: 'add-patient-dash', component: CreatePatientComponent, canActivate: [DoctorAuthGuardService] },
    { path: 'med-dash', component: MedicineDashComponent, canActivate: [DoctorAuthGuardService] },
    { path: 'add-medicine-dash', component: AddMedicineComponent, canActivate: [DoctorAuthGuardService] },
    { path: 'update-patient/:id', component: UpdatePatientComponent, canActivate: [DoctorAuthGuardService] }, // to go in patient with its id
    { path: 'patient-card/:id', component: ViewPatientCardComponent, canActivate: [DoctorAuthGuardService] },
    { path: 'update-medicine/:id', component: UpdateMedicineComponent, canActivate: [DoctorAuthGuardService] }, // to go in medicine with its id
    { path: 'doc-login', component: DocLoginComponent },
    { path: 'admin-login', component: AdminLoginComponent }
];
