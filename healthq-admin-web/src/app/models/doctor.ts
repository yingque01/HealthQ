export class Doctor {
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
  providerNo: string;
  userId: string;  // should a doctor always has an user acc?
}
