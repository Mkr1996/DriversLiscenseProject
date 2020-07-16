import { Component, OnInit } from '@angular/core';
import { Course } from './course';
import { CoursedataService } from '../coursedata.service';
@Component({
selector: 'app-report-screen',
templateUrl: './report-screen.component.html',
styleUrls: ['./report-screen.component.css']
})
export class ReportScreenComponent implements OnInit {
title: string= 'Course Registration';
initialCourses: Course[];
message: string;
constructor(private courseDataService: CoursedataService) {
// this.initialCourses = [
// {
// 'courseId': 1001,
// 'courseName': 'Angular',
// 'registrationFee': 25000,
// 'startDate': '10/05/2020',
// 'endDate': '10/15/2020',
// 'totalSeats': 300,
// 'seatsBooked': 300
// },
// {
// 'courseId': 1002,
// 'courseName': 'React',
// 'registrationFee': 30000,
// 'startDate': '11/05/2020',
// 'endDate': '11/15/2020',
// 'totalSeats': 300,
// 'seatsBooked': 50
// },
// {
// 'courseId': 1003,
// 'courseName': 'Polymer',
// 'registrationFee': 10000,
// 'startDate': '8/08/2020',
// 'endDate': '8/18/2020',
// 'totalSeats': 300,
// 'seatsBooked': 0
// }
// ];
}
ngOnInit() {
this.getCourses();
}
courseReg(courseName: string) {
this.message = `Your registration for ${courseName} is successful`;
}
getCourses() {
// this.initialCourses = [
// {
// 'courseId': 1001,
// 'courseName': 'Angular',
// 'registrationFee': 25000,
// 'startDate': '10/05/2020',
// 'endDate': '10/15/2020',
// 'totalSeats': 300,
// 'seatsBooked': 300
// },
// {
// 'courseId': 1002,
// 'courseName': 'React',
// 'registrationFee': 30000,
// 'startDate': '11/05/2020',
// 'endDate': '11/15/2020',
// 'totalSeats': 300,
// 'seatsBooked': 50
// },
// {
// 'courseId': 1003,
// 'courseName': 'Polymer',
// 'registrationFee': 10000,
// 'startDate': '8/08/2020',
// 'endDate': '8/18/2020',
// 'totalSeats': 300,
// 'seatsBooked': 0
// }
// ];
// this.initialCourses=this.courseDataService.getAllCourses();
this.courseDataService.getAllCourses().subscribe(
courses => {
this.initialCourses = courses;
},
error => console.log(error));
}
}