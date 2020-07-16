import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Course } from '../report-screen/course';

@Component({
selector: 'app-report',
templateUrl: './report.component.html',
styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

@Input()
courses : Course[];

@Output()onRegister = new EventEmitter<string>();

constructor() {
// this.courses = [
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
}
}