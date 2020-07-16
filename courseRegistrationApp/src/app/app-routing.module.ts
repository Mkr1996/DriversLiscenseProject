import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GuestApplicationComponent } from './Guest/guest-application/guest-application.component';
import { AdminLoginComponent } from './Admin/admin-login/admin-login.component';
import { AdminHomeComponent } from './Admin/admin-home/admin-home.component';
import { ViewApplicationsComponent } from './Admin/admin-home/view-applications/view-applications.component';
import { WelcomeComponent } from './welcome/welcome.component';


const routes: Routes = [
  { path: 'registration', component: GuestApplicationComponent },
  { path: 'adminLogin', component: AdminLoginComponent},
  { path: 'adminHome', component: AdminHomeComponent},
  { path: 'viewApplications', component: ViewApplicationsComponent},
  {path: 'welcome', component: WelcomeComponent},
  { path: '',   redirectTo: '/welcome', pathMatch: 'full' }, // redirect to `first-component`
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
