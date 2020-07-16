import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Application } from 'src/app/Shared/Models/Application';
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ViewApplicationService {

  private headers = new HttpHeaders({ 'Content-Type': 'application/json'});
  constructor(private http: HttpClient) { }

getApplications(): Observable<Application[]> {
  const url = environment.applicationAPIUrl + "/getApplications";
  //  const url = "/Airport";
    console.log(url);
    return this.http.get<Application[]>(url,{ headers: this.headers })
      .pipe(catchError(this.handleError));
  }
  
deleteApplication(applicationId: number): Observable<number> {
    const url = environment.applicationAPIUrl + "/Application/" + applicationId;
    return this.http.post<number>(url, applicationId, { headers: this.headers }).pipe(catchError(this.handleError));
  }

approveApplication(applicationId: number): Observable<string> {
    //    const url = environment.airportAPIUrl + "/Airport/" + airportId;
        const url = "/Airport";
        return this.http.post<string>(url, applicationId, { headers: this.headers }).pipe(catchError(this.handleError));
      }
      
  private handleError(err: HttpErrorResponse) {
    console.log(err);
    let errMsg: string = '';
  
    if (err.error instanceof Error) {
      errMsg = err.error.message;
      console.log(errMsg)
    }
    else if (typeof err.error === 'string') {
      errMsg = JSON.parse(err.error).message
    }
    else {
      if (err.status == 0)
        errMsg = "A connection to back end can not be established.";
      else
        errMsg = err.error.message;
    }
    return throwError(errMsg);
  }
}
