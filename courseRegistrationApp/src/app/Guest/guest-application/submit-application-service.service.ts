import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Application } from 'src/app/Shared/Models/Application';
import { Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SubmitApplicationService {

  //private tokenString: string = "Bearer " + sessionStorage.getItem("token").replace(new RegExp('"', 'g'),'');
  private headers = new HttpHeaders({ 'Content-Type': 'application/json'})
  constructor(private http: HttpClient) { }
  submitApplication(application: Application): Observable<any>
  {
    const url = environment.applicationAPIUrl + '/Application'
   return this.http.post<Application>(url,application,{headers: this.headers, responseType: 'text' as 'json'})
    .pipe(catchError(this.handleError));
    return null;
  }

  private handleError(err: HttpErrorResponse) {
    console.log(err);

    return throwError(err.message);
  }
}
