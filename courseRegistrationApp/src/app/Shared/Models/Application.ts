import { Address } from './Address';

export class Application {
    applicationId;
    applicationFor: string;
    class: string;
    motorcycle: string;
    applicationType: string;
    suffix: string;
    firstName: string;
    lastName: string;
    middleName: string;
    birthSurname: string;
    ssn: string;
    dateOfBirth: Date;
    sex: string;
    height: number;
    weight: number;
    eyeColor: string;
    hairColor: string;
    race: string;
    ethnicity: string;
    placeOfBirth: string;
    fatherLastName: string;
    motherMaidenName:string;
    residentialAddress: Address;
    mailingAddress: Address;
    phoneNo: number;
    email: string;
    signature: string;
    dateOfSignature: Date;
    approved: boolean=false;
}