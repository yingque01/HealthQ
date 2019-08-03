CREATE USER IF NOT EXISTS 'test'@'localhost' IDENTIFIED BY 'test';

CREATE DATABASE IF NOT EXISTS healthq;

CREATE TABLE IF NOT EXISTS healthq.doctors
(
    record_id bigint(20) unsigned not null auto_increment,
    id varchar(36) collate utf8mb4_bin not null,
    firstname varchar(50) collate utf8mb4_bin not null,
    lastname varchar(50) collate utf8mb4_bin not null,
    email varchar(128) collate utf8mb4_bin default null,
	phone varchar(25) collate utf8mb4_bin default null,
    providernumber varchar(30) collate utf8mb4_bin not null,
    primary key (record_id),
    unique key record_id (record_id),
    unique key doctors_id (id)
);

CREATE TABLE IF NOT EXISTS healthq.patients
(
    record_id bigint(20) unsigned not null auto_increment,
    id varchar(36) collate utf8mb4_bin not null,
    firstname varchar(50) collate utf8mb4_bin not null,
    lastname varchar(50) collate utf8mb4_bin not null,
    email varchar(128) collate utf8mb4_bin default null,
	phone varchar(25) collate utf8mb4_bin default null,
    medicarenumber varchar(30) collate utf8mb4_bin not null,
    primary key (record_id),
    unique key record_id (record_id),
    unique key patients_id (id)
);

CREATE TABLE IF NOT EXISTS healthq.clinics
(
	record_id bigint(20) unsigned not null auto_increment,
    id varchar(36) collate utf8mb4_bin not null,
    address1 varchar(100) collate utf8mb4_bin default null,
  	address2 varchar(100) collate utf8mb4_bin default null,
  	suburb_or_city varchar(50) collate utf8mb4_bin default null,
  	state_or_province varchar(50) collate utf8mb4_bin default null,
  	country varchar(50) collate utf8mb4_bin default null,
  	postal_code varchar(16) collate utf8mb4_bin default null,
    primary key (record_id),
    unique key record_id (record_id),
    unique key clinics_id (id)
);

CREATE TABLE IF NOT EXISTS healthq.clinic_rooms
(
	record_id bigint(20) unsigned not null auto_increment,
    id varchar(36) collate utf8mb4_bin not null,
    clinics_id varchar(36) collate utf8mb4_bin not null,
    primary key (record_id),
    unique key record_id (record_id),
    unique key clinic_rooms_id (id),
    constraint clinic_rooms_clinics_fk
        foreign key (clinics_id) references healthq.clinics (id) on update cascade on delete restrict
);

CREATE TABLE IF NOT EXISTS healthq.patient_queues
(
	record_id bigint(20) unsigned not null auto_increment,
    id varchar(36) collate utf8mb4_bin not null,
    clinics_id varchar(36) collate utf8mb4_bin not null,
    clinic_rooms_id varchar(36) collate utf8mb4_bin not null,
    doctors_id varchar(36) collate utf8mb4_bin not null,
    started_at datetime default current_timestamp not null,
    ended_at datetime default current_timestamp default null,
    primary key (record_id),
    unique key record_id (record_id),
    unique key patient_queues_id (id),
    constraint patient_queues_clinics_fk
        foreign key (clinics_id) references healthq.clinics (id) on update cascade on delete restrict,
    constraint patient_queues_clinic_rooms_fk
        foreign key (clinic_rooms_id) references healthq.clinic_rooms (id) on update cascade on delete restrictt,
   	constraint patient_queues_doctors_fk
        foreign key (doctors_id) references healthq.doctors (id) on update cascade on delete restrict    
);

CREATE TABLE IF NOT EXISTS healthq.patient_queue_requests
(
	record_id bigint(20) unsigned not null auto_increment,
    id varchar(36) collate utf8mb4_bin not null,
    patients_id varchar(36) collate utf8mb4_bin not null,
    patient_queues_id varchar(36) collate utf8mb4_bin not null,
    position_in_queue smallint(5) unsigned not null,
    average_waiting_minutes smallint(5) unsigned not null,
    primary key (record_id),
    unique key record_id (record_id),
    unique key patient_queue_requests_id (id),
    constraint patient_queue_requests_patients_fk
        foreign key (patients_id) references healthq.patients (id) on update cascade on delete restrict,
   	constraint patient_queue_requests_patient_queues_fk
        foreign key (patient_queues_id) references healthq.patient_queues (id) on update cascade on delete restrict    
);