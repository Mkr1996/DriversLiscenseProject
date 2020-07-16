import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/Shared/Models/Admin';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminLoginService } from './admin-login-service.service';
import { AdminLoginValidators } from 'src/app/Shared/Validators/admin.login.validator';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  admin: Admin;
  adminLoginForm: FormGroup;
  errorMessage: string;
  successMessage: string;
  tryToLogin: boolean = false;
  constructor(private fb: FormBuilder, private adminLoginService: AdminLoginService,
        private router: Router) {

    }

    ngOnInit() {
        this.admin = new Admin();
        this.createForm();

    }
    createForm() {

        this.adminLoginForm = this.fb.group({
            emailId: [this.admin.email, [Validators.required, AdminLoginValidators.validateEmailId], null],
            password: [this.admin.password, [Validators.required], null]
        });
    }



    adminLogin() {
        this.tryToLogin = true;
        this.errorMessage = null;
        this.successMessage = null;
        this.admin = this.adminLoginForm.value as Admin;
        this.adminLoginService.login(this.admin).subscribe(
            (response) => {
                this.admin = response
                sessionStorage.setItem("admin", JSON.stringify(this.admin));
                sessionStorage.setItem("userType", JSON.stringify("Admin"));
                this.tryToLogin = false;
                this.router.navigate(['/adminHome']);
            },
            (error) => {
                this.tryToLogin = false;
                this.errorMessage = <any>error;
            }
        )
    }

}
