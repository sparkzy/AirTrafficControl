/*******************************************************************************
   Air Traffic Control Database - Version 1.4
   Script: create_tables.sql
   Description: Creates and populates the air-traffic-control database.
   DB Server: Oracle
   Author: Bobby McGetrick
********************************************************************************/

/*******************************************************************************
   TO DO
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
ALTER SESSION SET "_ORACLE_SCRIPT"=true;
DROP USER atc CASCADE;

/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER atc
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to atc;
GRANT resource to atc;
GRANT create session TO atc;
GRANT create table TO atc;
GRANT create view TO atc;
GRANT create job to atc;

conn atc/p4ssw0rd

/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE aircraft
(
    aircraft_id NUMBER PRIMARY KEY,
    type_id NUMBER NOT NULL,
    size_id NUMBER NOT NULL
);

CREATE TABLE types
(
    type_id NUMBER PRIMARY KEY,
    type_name VARCHAR2(25) NOT NULL UNIQUE,
    type_priority NUMBER NOT NULL
);

CREATE TABLE sizes
(
    size_id NUMBER PRIMARY KEY,
    size_name VARCHAR2(25) NOT NULL,
    size_priority NUMBER NOT NULL
);

/*******************************************************************************
   Create Views
********************************************************************************/

/*******************************************************************************
   Create Junction Tables
********************************************************************************/

/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/

/*******************************************************************************
   Create Sequences
********************************************************************************/
CREATE SEQUENCE aircraft_id_seq;

CREATE SEQUENCE type_id_seq;

CREATE SEQUENCE size_id_seq;

/*******************************************************************************
   Create Triggers
********************************************************************************/        
    
/*******************************************************************************
   Create Stored Procedures
********************************************************************************/
    
/*******************************************************************************
   Create Functions
********************************************************************************/

/*******************************************************************************
   Create Jobs
********************************************************************************/

/*******************************************************************************
   Initialize Tables
********************************************************************************/
/**
* type
**/
INSERT INTO types (type_id, type_name, type_priority)
    VALUES (type_id_seq.nextval, 'Passenger', 0);

INSERT INTO types (type_id, type_name, type_priority)
    VALUES (type_id_seq.nextval, 'Cargo', 1);
    
/**
* size
**/
INSERT INTO sizes (size_id, size_name, size_priority)
    VALUES (size_id_seq.nextVal, 'Small', 1);

INSERT INTO sizes (size_id, size_name, size_priority)
    VALUES (size_id_seq.nextVal, 'Large', 0);

/*******************************************************************************
   Commit changes and exit
*******************************************************************************/
COMMIT;
EXIT;