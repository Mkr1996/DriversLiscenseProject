import { Component, OnInit, Input } from '@angular/core';
import { Application } from 'src/app/Shared/Models/Application';
import { ViewApplicationService } from './view-application.service';

@Component({
  selector: 'app-view-applications',
  templateUrl: './view-applications.component.html',
  styleUrls: ['./view-applications.component.css']
})
export class ViewApplicationsComponent implements OnInit {

  errorMessage: string = "";
  successMessage: string = "";
  application : Application;
  applicationList: Application[];
  applicationsShown: Boolean;
  @Input()
  ApplicationsReceived: Application;

  constructor(private viewApplicationService: ViewApplicationService) { }

  ngOnInit() {
    this.viewApplicationService.getApplications()
      .subscribe(applicationList => {
        console.log(applicationList);
        this.applicationList = applicationList;
      })

    this.applicationsShown = true;
    this.applicationList = JSON.parse(sessionStorage.getItem("Applications"));
  }

  // Remove Testing variable
  //airportId: number = 2000;
  deleteApplication(applicationId: number) {
    this.viewApplicationService.deleteApplication(applicationId).subscribe(
      (response) => {
        //console.log(response);
        this.successMessage = "The following Application has been successfully deleted with Application Id: " + response;
        this.errorMessage = "";
        let newApplicationList: Application[] = [];

        for (let dft of this.applicationList)
          if (dft.applicationId != applicationId)
            newApplicationList.push(dft);

        this.applicationList = newApplicationList;
        sessionStorage.setItem("Applications", JSON.stringify(this.applicationList));
      },
      error => {
        this.errorMessage = <any>error
        this.successMessage = "";
      }
    )
  }

  approveApplication(applicationId: number) {
    this.viewApplicationService.approveApplication(applicationId).subscribe(
      (response) => {
        //console.log(response);
        this.successMessage = "The following Application has been successfully approved with Application Id: " + response;
        this.errorMessage = "";

        for (let dft of this.applicationList)
          if (dft.applicationId == applicationId)
            dft.approved=true;
        sessionStorage.setItem("Applications", JSON.stringify(this.applicationList));
      },
      error => {
        this.errorMessage = <any>error
        this.successMessage = "";
      }
    )
  }
}
