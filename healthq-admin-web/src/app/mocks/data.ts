import {Clinic} from "../models/clinic";
import {Doctor} from "../models/doctor";
import {Patient} from "../models/patient";
import {PatientQueue} from "../models/queue";
import {PatientRequest} from "../models/request";

export class Data {
}

export const MOCK_CLINIC: Clinic = {
  recordId: 11,
  id: '8601948f-bfd6-49cc-b708-50b3b23e054b',
  status: 0,
  created: new Date(2019, 6, 1, 9, 0, 0, 0),
  last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
  name: 'test clinic',
  addressLine1: '1A Test St',
  addressLine2: '',
  suburb: 'Sydney',
  state: 'NSW',
  postcode: '2000'
};



export const MOCK_DOCTORS: Doctor[] = [
  {
    recordId: 31,
    id: '8f34440d-5e02-49d9-841f-db5958111106',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    firstName: 'Jennifer',
    middleName: '',
    lastName: 'Brown',
    gender: 'F',
    email: 'j.b@testd.com',
    phone: '02 1234 5678',
    providerNo: '1234561A',
    userId: null
  },
  {
    recordId: 32,
    id: 'a5be89ae-b75f-4e2d-88aa-2e8d226a8779',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    firstName: 'Bob',
    middleName: '',
    lastName: 'Smith',
    gender: 'M',
    email: 'b.s@testd.com',
    phone: '02 1234 5679',
    providerNo: '2234561A',
    userId: null
  },
  {
    recordId: 33,
    id: '148f5d3f-8a88-41bc-acd7-6acc34141194',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    firstName: 'Charlie',
    middleName: '',
    lastName: 'Williams',
    gender: 'M',
    email: 'c.w@testd.com',
    phone: '02 1234 5680',
    providerNo: '1334561A',
    userId: null
  },
  {
    recordId: 34,
    id: '7521b420-91e7-442f-8778-7ac7240178e2',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    firstName: 'Donald',
    middleName: '',
    lastName: 'Miller',
    gender: 'M',
    email: 'd.m@testd.com',
    phone: '02 1234 5681',
    providerNo: '1244561A',
    userId: null
  }
];


export const MOCK_PATIENTS: Patient[] = [
  {
    recordId: 51,
    id: 'c6b3a6fa-2d99-4412-a464-f540909eccf2',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    firstName: 'Kalim',
    middleName: '',
    lastName: 'Wilson',
    gender: 'M',
    email: 'k.w@testp.com',
    phone: '0401 234 567',
    medicareNo: '1234 56789 1/1',
    userId: null
  },
  {
    recordId: 52,
    id: '37925b9d-a51c-47e8-aa46-13bbd5ea5212',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    firstName: 'Peter',
    middleName: '',
    lastName: 'Moore',
    gender: 'M',
    email: 'p.m@testp.com',
    phone: '0401 234 678',
    medicareNo: '2234 56789 1/1',
    userId: null
  },
  {
    recordId: 53,
    id: '3e419cd1-16c4-44c5-b0c1-5975a589e9f3',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    firstName: 'Sophie',
    middleName: '',
    lastName: 'Lewis',
    gender: 'F',
    email: 's.l@testp.com',
    phone: '0401 234 890',
    medicareNo: '3234 56789 1/2',
    userId: null
  },
  {
    recordId: 54,
    id: 'f8c99fc8-8156-48ff-a112-2c97aa83ed7c',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    firstName: 'Victoria',
    middleName: '',
    lastName: 'Cook',
    gender: 'F',
    email: 'v.c@testp.com',
    phone: '0401 234 901',
    medicareNo: '4234 56789 1/1',
    userId: null
  },
  {
    recordId: 55,
    id: 'f53ce42a-cd06-4936-8090-736beecec5a9',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    firstName: 'Yarn',
    middleName: '',
    lastName: 'Ross',
    gender: 'M',
    email: 'y.r@testp.com',
    phone: '0401 234 012',
    medicareNo: '5234 56789 1/2',
    userId: null
  },
];


export const MOCK_QUEUES: PatientQueue[] = [
  {
    recordId: 71,
    id: 'd35eaa1a-a936-431d-9eb4-37211f058cd6',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    clinicRoomId: '1d4084b7-a095-450d-93ff-d3bc5c644179',
    doctorId: '8f34440d-5e02-49d9-841f-db5958111106',
    startDateTime: new Date(2019, 7, 5, 9, 0, 0, 0),
    endDateTime: new Date(2019, 7, 5, 17, 0, 0, 0)
  },
  {
    recordId: 72,
    id: '3dfadd00-445d-4571-831b-642d09fdb86a',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    clinicRoomId: '1d4084b7-a095-450d-93ff-d3bc5c644179',
    doctorId: 'a5be89ae-b75f-4e2d-88aa-2e8d226a8779',
    startDateTime: new Date(2019, 7, 6, 9, 0, 0, 0),
    endDateTime: new Date(2019, 7, 6, 17, 0, 0, 0)
  },
  {
    recordId: 73,
    id: 'fc53f069-211b-4cf1-9922-460f5b8cb6c4',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    clinicRoomId: '1d4084b7-a095-450d-93ff-d3bc5c644179',
    doctorId: '148f5d3f-8a88-41bc-acd7-6acc34141194',
    startDateTime: new Date(2019, 7, 7, 9, 0, 0, 0),
    endDateTime: new Date(2019, 7, 7, 17, 0, 0, 0)
  },
  {
    recordId: 74,
    id: '38053d40-6f4a-491a-ae8c-f7c9b9f6f6a1',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    clinicRoomId: '1d4084b7-a095-450d-93ff-d3bc5c644179',
    doctorId: '7521b420-91e7-442f-8778-7ac7240178e2',
    startDateTime: new Date(2019, 7, 8, 9, 0, 0, 0),
    endDateTime: new Date(2019, 7, 8, 12, 30, 0, 0)
  },
  {
    recordId: 75,
    id: 'f6625045-439d-477e-9d2d-c27621606cc5',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    clinicRoomId: '1d4084b7-a095-450d-93ff-d3bc5c644179',
    doctorId: '8f34440d-5e02-49d9-841f-db5958111106',
    startDateTime: new Date(2019, 7, 8, 12, 30, 0, 0),
    endDateTime: new Date(2019, 7, 8, 17, 0, 0, 0)
  },
  {
    recordId: 76,
    id: '94f09d48-a376-4c74-a0f5-2424b5422030',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    clinicRoomId: '1d4084b7-a095-450d-93ff-d3bc5c644179',
    doctorId: 'a5be89ae-b75f-4e2d-88aa-2e8d226a8779',
    startDateTime: new Date(2019, 7, 9, 9, 0, 0, 0),
    endDateTime: new Date(2019, 7, 9, 12, 30, 0, 0)
  },
  {
    recordId: 77,
    id: '734dfc47-7974-47cc-a0d2-ccfc2002c561',
    status: 0,
    created: new Date(2019, 6, 1, 9, 0, 0, 0),
    last_updated: new Date(2019, 6, 1, 9, 0, 0, 0),
    clinicRoomId: '1d4084b7-a095-450d-93ff-d3bc5c644179',
    doctorId: '148f5d3f-8a88-41bc-acd7-6acc34141194',
    startDateTime: new Date(2019, 7, 9, 12, 30, 0, 0),
    endDateTime: new Date(2019, 7, 9, 17, 0, 0, 0)
  }
];

export const MOCK_REQUESTS: PatientRequest[] = [
  {
    recordId: 1001,
    id: '641a7f50-d080-4751-bd80-73e7e6f96242',
    status: 0,
    created: new Date(2019, 7, 8, 9, 10, 0, 0),
    last_updated: new Date(2019, 7, 8, 9, 10, 0, 0),
    patientId: '37925b9d-a51c-47e8-aa46-13bbd5ea5212',
    patientQueueId: '38053d40-6f4a-491a-ae8c-f7c9b9f6f6a1',
    leftQueue: null,
    processed: null
  },
  {
    recordId: 1002,
    id: '6eb9366c-d0f5-4fb8-bc22-eac0eb796966',
    status: 0,
    created: new Date(2019, 7, 8, 9, 15, 10, 0),
    last_updated: new Date(2019, 7, 8, 9, 15, 10, 0),
    patientId: '3e419cd1-16c4-44c5-b0c1-5975a589e9f3',
    patientQueueId: '38053d40-6f4a-491a-ae8c-f7c9b9f6f6a1',
    leftQueue: null,
    processed: null
  },
  {
    recordId: 1003,
    id: '335ec09d-fbf9-4651-8b91-4a81d6e8fd35',
    status: 0,
    created: new Date(2019, 7, 8, 10, 2, 33, 0),
    last_updated: new Date(2019, 7, 8, 10, 2, 33, 0),
    patientId: 'f8c99fc8-8156-48ff-a112-2c97aa83ed7c',
    patientQueueId: '38053d40-6f4a-491a-ae8c-f7c9b9f6f6a1',
    leftQueue: null,
    processed: null
  },
  {
    recordId: 1004,
    id: 'c54f867c-708a-4def-bba9-44d5aa1f312f',
    status: 0,
    created: new Date(2019, 7, 8, 10, 31, 44, 0),
    last_updated: new Date(2019, 7, 8, 10, 31, 44, 0),
    patientId: 'f53ce42a-cd06-4936-8090-736beecec5a9',
    patientQueueId: '38053d40-6f4a-491a-ae8c-f7c9b9f6f6a1',
    leftQueue: null,
    processed: null
  },
];

