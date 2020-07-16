import { Injectable } from '@angular/core';
import { HttpHeaders, HttpErrorResponse, HttpClient } from '@angular/common/http';
import { Admin } from 'src/app/Shared/Models/Admin';
import { catchError } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdminLoginService {

  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    constructor(private http: HttpClient) {

    }
    login(admin: Admin): Observable<Admin> {
       // const url = environment.customerAPIUrl + '/customerLogin';
        const url = environment.adminAPIUrl + '/adminLogin';
        return this.http.post<Admin>(url,admin,{headers:this.headers})
        .pipe(catchError(this.handleError));

    }
    private handleError(err: HttpErrorResponse) {
        console.log(err)
        let errMsg:string='';
        if (err.error instanceof Error) {   
            errMsg=err.error.message;
            console.log(errMsg)
        }
         else if(typeof err.error === 'string'){
            errMsg=JSON.parse(err.error).message
        }
        else {
           if(err.status==0){ 
               errMsg="A connection to back end can not be established.";
           }else{
               errMsg=err.error.message;
           }
         }
            return throwError(errMsg);
    }
}
