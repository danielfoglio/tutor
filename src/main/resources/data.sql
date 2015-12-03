drop database if exists project;
CREATE DATABASE project;

USE project;

Drop Table if exists Tutor;
Drop Table if exists Courses;
Drop Table if exists Department;
Drop Table if exists teaches;
Drop Table if exists Student;
Drop Table if exists attends;
Drop Table if exists transaction;
Drop Table if exists appointment;
Drop Table if exists Registration;
Drop Table if exists Books;
Drop Table if exists recommend;
Drop Table if exists studies;
Drop Table if exists jobs;
Drop Table if exists applicants;
Drop Table if exists apply;
Drop Table if exists administrator_validate;
Drop Table if exists discusiion_forum_administers;
Drop Table if exists t_access;
Drop Table if exists s_access;
Drop Table if exists user;



# CREATE TABLES
create table user (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	login varchar(10) not null ,
	password_hash varchar(255) not null,
	role varchar(50) not null)
engine = InnoDb;

INSERT INTO user (login, password_hash, role)
VALUES ('t101', '$2a$10$dHUKxYLEJq.pcx6b9mLM8OZWT8ZE7CYfsA9ZF0eYljGaWsp/9sUZe', 'TUTOR');
INSERT INTO user (login, password_hash, role)
VALUES ('t102', '$2a$10$dHUKxYLEJq.pcx6b9mLM8OZWT8ZE7CYfsA9ZF0eYljGaWsp/9sUZe', 'TUTOR');
INSERT INTO user (login, password_hash, role)
VALUES ('t103', '$2a$10$dHUKxYLEJq.pcx6b9mLM8OZWT8ZE7CYfsA9ZF0eYljGaWsp/9sUZe', 'TUTOR');
INSERT INTO user (login, password_hash, role)
VALUES ('t104', '$2a$10$dHUKxYLEJq.pcx6b9mLM8OZWT8ZE7CYfsA9ZF0eYljGaWsp/9sUZe', 'TUTOR');

INSERT INTO user (login, password_hash, role)
VALUES ('S101', '$2a$10$dHUKxYLEJq.pcx6b9mLM8OZWT8ZE7CYfsA9ZF0eYljGaWsp/9sUZe', 'USER');
INSERT INTO user (login, password_hash, role)
VALUES ('S102', '$2a$10$dHUKxYLEJq.pcx6b9mLM8OZWT8ZE7CYfsA9ZF0eYljGaWsp/9sUZe', 'USER');
INSERT INTO user (login, password_hash, role)
VALUES ('S103', '$2a$10$dHUKxYLEJq.pcx6b9mLM8OZWT8ZE7CYfsA9ZF0eYljGaWsp/9sUZe', 'USER');
INSERT INTO user (login, password_hash, role)
VALUES ('S104', '$2a$10$dHUKxYLEJq.pcx6b9mLM8OZWT8ZE7CYfsA9ZF0eYljGaWsp/9sUZe', 'USER');


CREATE TABLE Tutor(
TID VARCHAR(10),
Fname VARCHAR(20),
Lname VARCHAR(20),
phone VARCHAR(20),
payRate FLOAT,
availability VARCHAR(30),
T_email VARCHAR(20),
instruction_mode CHAR(20) CHECK (instruction_mode IN ('Online','Face to Face')),
specialization VARCHAR(30),
course_taught VARCHAR(30),
PRIMARY KEY(TID));

INSERT INTO tutor VALUES
('t101', 'John', 'Smith', 9801234123, 100, 'yes', 'jsmith@uncc.edu', 'online', 'Information Technology', 'Database Systems');
INSERT INTO tutor VALUES
('t102', 'Kane', 'William', 98701122345, 60, 'yes', 'kwilliam@gmail.com', 'online', 'Computer Science', 'Java');
INSERT INTO tutor VALUES
('t103', 'kevin', 'Hart', 9803456789, 80, 'yes', 'khart@gmail.com', 'online', 'Computer Science', 'Algorithms');
INSERT INTO tutor VALUES
('t104', 'Will', 'Smith', 9902233822, 50, 'yes', 'wsmith@gmail.com', 'Face to Face', 'Information Technology', 'NBAD');

CREATE TABLE Courses(
courseID VARCHAR(10),
course_name VARCHAR(20),
PRIMARY KEY(courseID));

INSERT INTO Courses VALUES ('c100','Database Systems');
INSERT INTO Courses VALUES ('c101','Java');
INSERT INTO Courses VALUES ('c102','Algorithms');
INSERT INTO Courses VALUES ('c103','NBAD');


CREATE TABLE Department(
DeptID VARCHAR(10),
DeptName VARCHAR(200),
PRIMARY KEY(DeptID));

INSERT INTO Department VALUES ('d100','Information Technology');
INSERT INTO Department VALUES ('d101','Computer Science');


CREATE TABLE Teaches(
courseID VARCHAR(10),
TID VARCHAR(10) NOT NULL,
DeptID VARCHAR(10) NOT NULL,
PRIMARY KEY(courseID, TID, DeptID),
FOREIGN KEY(TID) REFERENCES Tutor(TID),
FOREIGN KEY(courseID) REFERENCES Courses(courseID),
FOREIGN KEY(DeptID) REFERENCES Department(DeptID));

INSERT INTO Teaches VALUES ('c100','t101','d100');
INSERT INTO Teaches VALUES ('c101','t102','d101');
INSERT INTO Teaches VALUES ('c102','t103','d101');
INSERT INTO Teaches VALUES ('c103','t104','d100');

CREATE TABLE Student(
SID VARCHAR(10),
Fname VARCHAR(30),
Lname VARCHAR(30),
phone VARCHAR(20),
degree VARCHAR(30),
degree_standing VARCHAR(15),
S_email VARCHAR(200),
courseID VARCHAR(10),
PRIMARY KEY(SID),
FOREIGN KEY(courseID) REFERENCES Courses(courseID));

INSERT INTO Student VALUES ('s101','John','Cena','8790765123','Bachelor of Engineering','MS','jcena@gmail.com','c100');
INSERT INTO Student VALUES ('s102','Chris','Gayle','8756784365','Bachelor of Engineering','MS','chgaylestorm@gmail.com','c101');
INSERT INTO Student VALUES ('s103','Virat','Kohli','9807654321','Bachelor of Engineering','MS','viratmcbc@gmail.com','c102');
INSERT INTO Student VALUES ('s104','Damien','Martin','9987678798','Bachelor of Engineering','MS','dmartin@gmail.com','c103');

CREATE TABLE Attends(
SID VARCHAR(10),
courseID VARCHAR(10) NOT NULL,
PRIMARY KEY(SID, courseID),
FOREIGN KEY(SID) REFERENCES Student(SID),
FOREIGN KEY(courseID) REFERENCES Courses(courseID));

INSERT INTO Attends VALUES('s101','c100');
INSERT INTO Attends VALUES('s102','c101');
INSERT INTO Attends VALUES('s103','c102');
INSERT INTO Attends VALUES('s104','c103');

CREATE TABLE Transaction(
transID INT(10),
TID VARCHAR(10),
SID VARCHAR(10),
trans_mode VARCHAR(20) CHECK (trans_mode IN('cash','check')),
amount FLOAT(5,2),
PRIMARY KEY(transID, TID, SID),
FOREIGN KEY(SID) REFERENCES Student(SID),
FOREIGN KEY(TID) REFERENCES Tutor(TID));

INSERT INTO Transaction VALUES ('121','t101','s101','cash','100');
INSERT INTO Transaction VALUES ('122','t102','s102','cash','90');
INSERT INTO Transaction VALUES ('123','t103','s103','check','100');
INSERT INTO Transaction VALUES ('124','t104','s104','cash','70');

CREATE TABLE Appointment(
TID VARCHAR(10),
SID VARCHAR(10),
duration INT,
startTime TIME,
meetingDate DATE,
PRIMARY KEY(TID,SID),
FOREIGN KEY(TID) REFERENCES Tutor(TID),
FOREIGN KEY(SID) REFERENCES Student(SID));

INSERT INTO Appointment VALUES ('t101','s101','2','09:30:00','2015-11-10');
INSERT INTO Appointment VALUES ('t102','s102','1','09:30:00','2015-11-11');
INSERT INTO Appointment VALUES ('t103','s103','1','10:00:00','2015-11-12');
INSERT INTO Appointment VALUES ('t104','s104','3','10:30:00','2015-11-14');

CREATE TABLE Registration(
TID VARCHAR(10),
SID VARCHAR(10),
status VARCHAR(10),
PRIMARY Key(TID,SID),
FOREIGN KEY(TID) REFERENCES Tutor(TID),
FOREIGN KEY(SID) REFERENCES Student(SID));

INSERT INTO Registration VALUES ('t101','s101','approved');
INSERT INTO Registration VALUES ('t102','s102','approved');
INSERT INTO Registration VALUES ('t103','s103','pending');
INSERT INTO Registration VALUES ('t104','s104','approved');

CREATE TABLE Books(
BID VARCHAR(10),
bookname VARCHAR(200),
author VARCHAR(100),
PRIMARY KEY(BID));

INSERT INTO Books VALUES ('b101','Principles of database systems','k S Madhav');
INSERT INTO Books VALUES ('b102','Concepts of Java','R K Moorthy');
INSERT INTO Books VALUES ('b103','Fundamentals of Algorithms','J Peter');
INSERT INTO Books VALUES ('b104','NBAD concepts','Kitrick E S');

CREATE TABLE Recommend(
courseID VARCHAR(10),
BID VARCHAR(10),
PRIMARY KEY(courseID, BID),
FOREIGN KEY(courseID) REFERENCES Courses(courseID),
FOREIGN KEY(BID) REFERENCES Books(BID));

INSERT INTO Recommend VALUES ('c100','b101');
INSERT INTO Recommend VALUES ('c101','b102');
INSERT INTO Recommend VALUES ('c102','b103');
INSERT INTO Recommend VALUES ('c103','b104');

CREATE TABLE Studies(
BID VARCHAR(10),
SID VARCHAR(10),
PRIMARY KEY(BID, SID),
FOREIGN KEY(BID) REFERENCES Books(BID),
FOREIGN KEY(SID) REFERENCES Student(SID));

INSERT INTO Studies VALUES ('b101','s101');
INSERT INTO Studies VALUES ('b102','s102');
INSERT INTO Studies VALUES ('b103','s103');
INSERT INTO Studies VALUES ('b104','s104');

CREATE TABLE Jobs(
JobID VARCHAR(10),
Jobdesc VARCHAR(50),
Qualification VARCHAR(50),
PRIMARY KEY(JobID));

INSERT INTO Jobs  VALUES ('j101','Tutor for DB','Graduate or equivalent');
INSERT INTO Jobs  VALUES ('j102','Tutor for java','Graduate or equivalent');
INSERT INTO Jobs  VALUES ('j103','Tutor for Algorithms','Graduate or equivalent');
INSERT INTO Jobs  VALUES ('j104','Tutor for NBAD','Graduate or equivalent');

CREATE TABLE Applicants(
applicantID VARCHAR(10),
fname VARCHAR(20),
lname VARCHAR(20),
skills VARCHAR(30),
contactno BIGINT(20),
PRIMARY KEY(applicantID));

INSERT INTO Applicants VALUES ('a101','John','Smith','Database','9801234123');
INSERT INTO Applicants VALUES ('a102','Kane','Williamson','Java','98701122345');
INSERT INTO Applicants VALUES ('a103','Kevin','Hart','Algorithms','9803456789');
INSERT INTO Applicants VALUES ('a104','Will','Smith','NBAD','9902233822');
INSERT INTO Applicants VALUES ('a105','Hary','Jill','Database','9801234156');
INSERT INTO Applicants VALUES ('a106','Crag','Ford','Java','9801234254');

CREATE TABLE Apply(
applicantID VARCHAR(10),
JobID VARCHAR(10),
DeptID VARCHAR(10),
courseID VARCHAR(10),
PRIMARY KEY(applicantID, JobID, DeptID, courseID),
FOREIGN KEY(applicantID) REFERENCES Applicants(applicantID),
FOREIGN KEY(JobID) REFERENCES Jobs(JobID),
FOREIGN KEY(DeptID) REFERENCES Department(DeptID),
FOREIGN KEY(courseID) REFERENCES Courses(courseID));

INSERT INTO Apply VALUES ('a101','j101','d100','c100');
INSERT INTO Apply VALUES ('a102','j102','d101','c101');
INSERT INTO Apply VALUES ('a103','j103','d101','c102');
INSERT INTO Apply VALUES ('a104','j104','d100','c103');
INSERT INTO Apply VALUES ('a105','j101','d100','c100');
INSERT INTO Apply VALUES ('a106','j102','d101','c101');

CREATE TABLE Administrator_Validate(
username VARCHAR(20),
password VARCHAR(20),
applicantID VARCHAR(10),
PRIMARY KEY(username),
FOREIGN KEY (applicantID) REFERENCES Applicants(applicantID));

INSERT INTO Administrator_Validate VALUES ('Dan','abcd1234','a101');
INSERT INTO Administrator_Validate VALUES ('Ran','abcd12','a103');
INSERT INTO Administrator_Validate VALUES ('Sam','abcd123','a106');

CREATE TABLE DiscussionForum_Administers(
discussionID VARCHAR(10),
chat_text VARCHAR(200),
username VARCHAR(20) NOT NULL,
PRIMARY KEY(discussionID),
FOREIGN KEY(username) REFERENCES Administrator_Validate(username));

INSERT INTO DiscussionForum_Administers VALUES ('ds100','Use this form to discuss all your queries','Dan');
INSERT INTO DiscussionForum_Administers VALUES ('ds101','Please do not misuse the discuss form','Ran');
INSERT INTO DiscussionForum_Administers VALUES ('ds102','Please suggest a book for DB','Sam');


CREATE TABLE T_Access(
TID VARCHAR(10),
discussionID VARCHAR(10),
PRIMARY KEY(TID,discussionID),
FOREIGN KEY(TID) REFERENCES Tutor(TID),
FOREIGN KEY (discussionID) REFERENCES DiscussionForum_Administers(discussionID));

INSERT INTO T_Access VALUES ('t101','ds100');
INSERT INTO T_Access VALUES ('t102','ds101');

CREATE TABLE S_Access(
SID VARCHAR(10),
discussionID VARCHAR(10),
PRIMARY KEY(SID,discussionID),
FOREIGN KEY(SID) REFERENCES Student(SID),
FOREIGN KEY (discussionID) REFERENCES DiscussionForum_Administers(discussionID));

INSERT INTO S_Access VALUES ('s101','ds102');