create table EMPLOYEE(
     Fname varchar(30),
     Minit varchar(10),
     Lname varchar(30),
     Ssn int(15),
     Bdate date,
     Address varchar(50),
     Sex varchar(1),
     Salary int(10),
     Super_ssn int(15),
     Dno int(1),
     constraint pk_employee primary key(Ssn)
 );

 create table DEPARTMENT(
     Dname varchar(20),
     Dnumber int(5),
     Mgr_Ssn int(15),
     Mgr_start_date date,
     constraint pk_department primary key(Dnumber)
 );


 create table PROJECT(
     Pname varchar(20),
     Pnumber int(5),
     Plocation varchar(20),
     Dnum int(5),
     constraint pk_project primary key(Pnumber)
 );

 create table WORKS_ON(
      Essn int(15),
      Pno int(5),
      Hours float(20,10),
     constraint pk_works_on primary key(Essn,Pno)
 );

 create table DEPENDENT(
      Essn int(15),
      Dependent_name varchar(20),
      Sex varchar(1),
      Bdate date,
      Relationship varchar(15),
      constraint pk_dependent primary key(Essn,Dependent_name)
 );

 alter table EMPLOYEE
 add constraint fk_Super_ssn foreign key(Super_ssn)
 references EMPLOYEE(Ssn);

 alter table EMPLOYEE
 add constraint fk_Dno foreign key(Dno)
 references DEPARTMENT(Dnumber);

 alter table DEPARTMENT
 add constraint fk_Mgr_ssn foreign key(Mgr_ssn)
 references EMPLOYEE(Ssn);

 alter table PROJECT
 add constraint fk_Dnum foreign key(Dnum)
 references DEPARTMENT(Dnumber);

 alter table WORKS_ON
 add constraint fk_Essn foreign key(Essn)
 references EMPLOYEE(Ssn);

 alter table WORKS_ON
 add constraint fk_Pno foreign key(Pno)
 references PROJECT(Pnumber);

 alter table DEPENDENT
 add constraint fk_Essn_depend foreign key(Essn)
 references EMPLOYEE(Ssn);

 insert into EMPLOYEE(Fname,Minit,Lname,Ssn,Bdate,Address,Sex,Salary,Super_ssn,Dno)
      values('John','B','Smith',123456789,'1965-01-09','731 Fondren,Houston ,TX','M',30000,NULL,NULL),
      ('Franklin','T','Wong',333445555,'1955-12-08','638 Voss,Houston ,TX','M',40000,NULL,NULL),
      ('Alicia','J','Zelaya',999887777,'1968-01-19', '3321 Castle, Spring, TX','F',25000,NULL,NULL),
      ('Jennifer','S','Wallace',987654321,'1941-06-20', '291 Berry, Bellaire, TX','F',43000,NULL,NULL),
      ('Ramesh','K','Narayan',666884444,'1962-09-15', '975 Fire Oak, Humble, TX','M',38000,NULL,NULL),
      ('Joyce','A','English',453453453,'1971-07-31', '5631 Rice, Houston, TX','F',25000,NULL,NULL),
      ('Ahmad','V','Jabbar',987987987,'1969-03-29', '980 Dallas, Houston, TX','M',25000,NULL,NULL),
      ('James','E','Borg',888665555,'1937-11-10', '450 Stone, Houston, TX','M',55000,NULL,NULL);

 insert into DEPARTMENT(Dname,Dnumber,Mgr_ssn,Mgr_start_date)
      values('Research',5,NULL,'1988-05-22'),
      ('Administration',4,NULL,'1995-01-01'),
      ('Headquarters',1,NULL,'1981-06-19');

 insert into PROJECT(Pname,Pnumber,Plocation,Dnum)
      values('ProductX',1,'Bellaire',NULL),
      ('ProductY',2,'Sugarland',NULL),
      ('ProductZ',3,'Houston',NULL),
      ('Computerization',10,'Stafford',NULL),
      ('Reorganization',20,'Houston',NULL),
      ('Newbenefits',30,'Stafford',NULL);

 INSERT INTO WORKS_ON (Essn, Pno, Hours) VALUES
     (123456789, 1, 32.5),
     (123456789, 2, 7.5),
     (666884444, 3, 40.0),
     (453453453, 1, 10.0),
     (453453453, 2, 20.0),
     (333445555, 3, 10.0),
     (333445555, 1, 10.0),
     (333445555, 2, 10.0),
     (999887777, 30, 30.0),
     (999887777, 10, 10.0),
     (987987987, 10, 35.0),
     (987987987, 30, 5.0),
     (987654321, 30, 20.0),
     (987654321, 20, 15.0),
     (888665555, 20, NULL);

 INSERT INTO DEPENDENT (Essn, Dependent_name, Sex, Bdate, Relationship) VALUES
     (333445555, 'Alice', 'F', '1986-04-05', 'Daughter'),
     (333445555, 'Theodore', 'M', '1983-10-25', 'Son'),
     (333445555, 'Joy', 'F', '1958-05-03', 'Spouse'),
     (987654321, 'Abner', 'M', '1942-02-28', 'Spouse'),
     (123456789, 'Michael', 'M', '1988-01-04', 'Son'),
     (123456789, 'Alice', 'F', '1988-12-30', 'Daughter'),
     (123456789, 'Elizabeth', 'F', '1967-05-05', 'Spouse');


UPDATE EMPLOYEE
SET super_ssn = 333445555, dno = 5
WHERE Ssn = 123456789;

UPDATE EMPLOYEE
SET super_ssn = 888665555, dno = 5
WHERE Ssn = 333445555;

UPDATE EMPLOYEE
SET super_ssn = 987654321, dno = 4
WHERE Ssn = 999887777;

UPDATE EMPLOYEE
SET super_ssn = 888665555, dno = 4
WHERE Ssn = 987654321;

UPDATE EMPLOYEE
SET super_ssn = 333445555, dno = 5
WHERE Ssn = 666884444;

UPDATE EMPLOYEE
SET super_ssn = 987654321, dno = 4
WHERE Ssn = 453453453;

UPDATE EMPLOYEE
SET super_ssn = 987654321, dno = 4
WHERE Ssn = 987987987;

UPDATE EMPLOYEE
SET super_ssn = NULL, dno = 1
WHERE Ssn = 888665555;


UPDATE DEPARTMENT
SET mgr_ssn = 333445555
WHERE Dnumber = 5;

UPDATE DEPARTMENT
SET mgr_ssn = 987654321
WHERE Dnumber = 4;

UPDATE DEPARTMENT
SET mgr_ssn = 888665555
WHERE Dnumber = 1;

UPDATE PROJECT
SET Dnum = 5
WHERE Pnumber = 1;

UPDATE PROJECT
SET Dnum = 5
WHERE Pnumber = 2;

UPDATE PROJECT
SET Dnum = 5
WHERE Pnumber = 3;

UPDATE PROJECT
SET Dnum = 4
WHERE Pnumber = 10;

UPDATE PROJECT
SET Dnum = 1
WHERE Pnumber = 20;

UPDATE PROJECT
SET Dnum = 4
WHERE Pnumber = 30;
