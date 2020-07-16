import { Injectable } from '@angular/core';
import { Course } from './report-screen/course';
import { Observable } from '../../node_modules/rxjs';
import { HttpClient } from '../../node_modules/@angular/common/http';
import { retry } from 'rxjs/operators';
@Injectable({
providedIn: 'root'
})
export class CoursedataService {
private coursesUrl = './assets/courses.json';
constructor(private http: HttpClient) { }
getAllCourses(): Observable<Course[]> {
return this.http.get<Course[]>(
this.coursesUrl
).pipe(
retry(5));
}
}