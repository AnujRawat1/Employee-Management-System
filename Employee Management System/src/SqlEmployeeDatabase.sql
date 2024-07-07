CREATE DATABASE EmployeeMangement;
USE EmployeeMangement ;

CREATE TABLE IF NOT EXISTS login (
	username VARCHAR(30) ,
    password VARCHAR(30) 
);

INSERT INTO login (username,password) VALUES ("CEO" , "ceo123"),("Admin","1234") ;

SELECT * FROM login ;


CREATE TABLE IF NOT EXISTS employee (
	name VARCHAR(100) ,
    fathersName VARCHAR(100) ,
    dob VARCHAR(100) ,
    salary VARCHAR(100)  ,
    address VARCHAR(100) ,
    phoneno VARCHAR(100) ,
    email VARCHAR(100) ,
    education VARCHAR(100) ,
    designation VARCHAR(100) ,
    adhaar VARCHAR(100) ,
    empId VARCHAR(100) 
);

-- To Print employee table
SELECT * FROM employee ;

SET SQL_SAFE_UPDATES = 0;





