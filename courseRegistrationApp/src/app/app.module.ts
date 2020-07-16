import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ReportScreenComponent } from './report-screen/report-screen.component';
import { SalutationPipe } from './salutation.pipe';
import { CoursedataService } from './coursedata.service';
import { HttpClientModule } from '@angular/common/http';
import { GuestApplicationComponent } from './Guest/guest-application/guest-application.component'; 
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ReportComponent } from './report/report.component';
import { GuestLandingPageComponent } from './guest/guest-landing-page/guest-landing-page.component';
import { AdminHomeComponent } from './Admin/admin-home/admin-home.component';
import { AdminLoginComponent } from './Admin/admin-login/admin-login.component';
import { ViewApplicationsComponent } from './Admin/admin-home/view-applications/view-applications.component';
import { WelcomeComponent } from './welcome/welcome.component';

@NgModule({
declarations: [
AppComponent,
HeaderComponent,
FooterComponent,
ReportComponent,
ReportScreenComponent,
SalutationPipe,
GuestApplicationComponent,
GuestLandingPageComponent,
AdminHomeComponent,
AdminLoginComponent,
ViewApplicationsComponent,
WelcomeComponent,
],
imports: [
BrowserModule,
AppRoutingModule,
HttpClientModule,
FormsModule,
ReactiveFormsModule
],
providers: [CoursedataService],
bootstrap: [AppComponent]
})
export class AppModule { }
