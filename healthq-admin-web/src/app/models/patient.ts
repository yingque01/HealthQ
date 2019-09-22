export class Patient {
  recordId: number;
  id: string;
  status: number;
  created: Date;
  last_updated: Date;
  firstName: string;
  middleName: string;
  lastName: string;
  gender: string;
  email: string;
  phone: string;
  medicareNo: string;
  userId: string; // can be null / empty, which means this is a walk-in patient
}
