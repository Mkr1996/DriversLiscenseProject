import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Application } from 'src/app/Shared/Models/Application';
import { SubmitApplicationService } from './submit-application-service.service';


@Component(
    {
        selector: "registration",
        templateUrl: "./guest-application.component.html"
    }
)
export class GuestApplicationComponent implements OnInit {

    application: Application;
    submitApplicationForm: FormGroup;
    errorMessage: string;
    submitted: boolean;
    submittedApplication: string;
    successMessage: string;
    constructor(private fb: FormBuilder, private submitApplicationService: SubmitApplicationService) {

    }

    ngOnInit() {
        this.application = new Application();
        this.createForm();

    }
    createForm() {

        this.submitApplicationForm = this.fb.group({
            applicationFor: [this.application.applicationFor, [Validators.required], null],
            class: [this.application.class, [Validators.required], null],
            motorcycle: [this.application.motorcycle, [Validators.required], null],
            applicaitonType: [this.application.applicationType, [Validators.required], null],
            suffix: [this.application.suffix, [Validators.required], null],
            firstName: [this.application.firstName, [Validators.required], null],
            lastName: [this.application.lastName, [Validators.required], null],
            middleName: [this.application.middleName, [Validators.required], null],
            birthSurName: [this.application.birthSurname, [Validators.required], null],
            ssn: [this.application.ssn, [Validators.required], null],
            dateOfBirth: [this.application.dateOfBirth, [Validators.required], null],
            sex: [this.application.sex, [Validators.required], null],
            height: [this.application.height, [Validators.required], null],
            weight: [this.application.weight, [Validators.required], null],
            eyeColor: [this.application.eyeColor, [Validators.required], null],
            hairColor: [this.application.hairColor, [Validators.required], null],
            race: [this.application.race, [Validators.required], null],
            ethnicity: [this.application.ethnicity, [Validators.required], null],
            placeOfBirth: [this.application.placeOfBirth, [Validators.required], null],
            fatherLastName: [this.application.fatherLastName, [Validators.required], null],
            motherMaidenName: [this.application.motherMaidenName, [Validators.required], null],
            residentialAddress: this.fb.group({
              streetAddress1: ["", [Validators.required],null],
              streetAddress2: ["", [Validators.required], null],
              city: ["", [Validators.required], null],
              state: ["", [Validators.required], null],
              zip: ["", [Validators.required], null],
              country: ["", [Validators.required], null]
            }),
            mailingAddress: this.fb.group({
              streetAddress1: ["", [Validators.required],null],
              streetAddress2: ["", [Validators.required],null],
              city: ["", [Validators.required],null],
              state: ["", [Validators.required],null],
              zip: ["", [Validators.required],null],
              country: ["", [Validators.required],null]
            }),
            phoneNo: [this.application.phoneNo, [Validators.required], null],
            email: [this.application.email, [Validators.required], null],
            signature: [this.application.signature, [Validators.required], null],
            dateOfSignature: [this.application.dateOfSignature, [Validators.required], null],

        });
    }

    submitApplication()
    {
      this.application.applicationFor = this.submitApplicationForm.value.applicationFor;
      this.application.class = this.submitApplicationForm.value.class;
      this.application.motorcycle = this.submitApplicationForm.value.motorcycle;
      this.application.applicationType = this.submitApplicationForm.value.applicaitonType;
      this.application.suffix = this.submitApplicationForm.value.suffix;
      this.application.firstName = this.submitApplicationForm.value.firstName;
      this.application.lastName = this.submitApplicationForm.value.lastName;
      this.application.middleName = this.submitApplicationForm.value.middleName;
      this.application.birthSurname = this.submitApplicationForm.value.birthSurName;
      this.application.ssn = this.submitApplicationForm.value.ssn;
      this.application.dateOfBirth = this.submitApplicationForm.value.dateOfBirth;
      this.application.sex = this.submitApplicationForm.value.sex;
      this.application.height = this.submitApplicationForm.value.height;
      this.application.weight = this.submitApplicationForm.value.weight;
      this.application.eyeColor = this.submitApplicationForm.value.eyeColor;
      this.application.hairColor = this.submitApplicationForm.value.hairColor;
      this.application.race = this.submitApplicationForm.value.race;
      this.application.ethnicity = this.submitApplicationForm.value.ethnicity;
      this.application.placeOfBirth = this.submitApplicationForm.value.placeOfBirth;
      this.application.fatherLastName = this.submitApplicationForm.value.motherMaidenName;
      this.application.motherMaidenName = this.submitApplicationForm.value.class;
      this.application.residentialAddress = this.submitApplicationForm.value.residentialAddress;
      this.application.mailingAddress = this.submitApplicationForm.value.mailingAddress;
      this.application.phoneNo = this.submitApplicationForm.value.phoneNo;
      this.application.email = this.submitApplicationForm.value.email;
      this.application.signature = this.submitApplicationForm.value.signature;
      this.application.dateOfSignature = this.submitApplicationForm.value.dateOfSignature;
      this.submitApplicationService.submitApplication(this.application).subscribe(
        (Response) => {this.submitted = true;
          this.submittedApplication = Response;
        }
      )
    }

}