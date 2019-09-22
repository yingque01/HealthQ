export class PatientRequest {
  recordId: number;
  id: string;
  status: number;
  created: Date;
  last_updated: Date;
  patientId: string;
  patientQueueId: string;
  // joined queue time == created
  leftQueue: Date;
  processed: Date;
  // think: more complicated case: admin moves a patient request over to another queue. how do we track? how do we set all these dates etc?
}
