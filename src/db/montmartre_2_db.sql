use montmartre_2_db;
describe users;
 INSERT INTO users (user_name, user_surname, user_date_of_birth, user_email, user_login, password, role)
VALUES ('Alesya', 'Yesemchik', '1980-09-12', 'alis@mail.ru', 'uuu', '1234', '1');
 INSERT INTO users (user_name, user_surname, user_date_of_birth, user_email, user_login, password, role)
VALUES ('Irina', 'Ivanova', '1960-08-22', 'irina@mail.ru', 'uuu1', '1234', '1');
 INSERT INTO users (user_name, user_surname, user_date_of_birth, user_email, user_login, password, role)
VALUES ('Gennadiy', 'Petrov', '1983-08-10', 'gena@mail.ru', 'uuu2', '1234', '1');
 INSERT INTO users (user_name, user_surname, user_date_of_birth, user_email, user_login, password, role)
VALUES ('Will', 'Smit', '1989-03-04', 'will@mail.ru', 'uuu3', '1234', '0');

create table employees (employee_id int (20) not null auto_increment, employee_name varchar (40), employee_surname varchar (40), 
employee_date_of_birth date, employee_profession varchar (40), employee_salary int (20), employee_email varchar (20) not null, 
employee_login varchar (20) not null unique, employee_password varchar (20), employee_role int (3) default 2, primary key (employee_id)); 
 INSERT INTO employees (employee_name, employee_surname, employee_date_of_birth, employee_profession, employee_salary, employee_email, employee_login, employee_password)
VALUES ('Anna', 'Guchik', '1985-09-12', 'povar','1000', 'anna@mail.ru', 'uuu4', '1234');

 INSERT INTO employees (employee_name, employee_surname, employee_date_of_birth, employee_profession, employee_salary, employee_email, employee_login, employee_password)
VALUES ('Alesya', 'Sergeeva', '1987-07-22', 'worker','500', 'alesya1@mail.ru', 'uuu7', '1234');
 INSERT INTO employees (employee_name, employee_surname, employee_date_of_birth, employee_profession, employee_salary, employee_email, employee_login, employee_password)
VALUES ('Igor', 'Sydorov', '1988-03-15', 'povar','1000', 'igor@mail.ru', 'uuu8', '1234');
INSERT INTO employees (employee_name, employee_surname, employee_date_of_birth, employee_profession, employee_salary, employee_email, employee_login, employee_password)
VALUES ('Victor', 'Petrov', '1977-09-22', 'povar','1000', 'victor@mail.ru', 'uuu9', '1234');
 INSERT INTO employees (employee_name, employee_surname, employee_date_of_birth, employee_profession, employee_salary, employee_email, employee_login, employee_password)
VALUES ('Nikolay', 'Ivanov', '1990-11-30', 'worker','3000', 'nikolay@mail.ru', 'uuu10', '1234');

UPDATE employees SET employee_salary = 500 WHERE employee_id = 10;
INSERT INTO employees (employee_name, employee_surname, employee_date_of_birth, employee_profession, employee_salary, employee_email, employee_login, employee_password, employee_role)
VALUES ('Aleksey', 'Shevchenko', '1965-10-22', 'director','3000', 'aleksey@mail.ru', 'uuu5', '1234','0');

 INSERT INTO employees (employee_name, employee_surname, employee_date_of_birth, employee_profession, employee_salary, employee_email, employee_login, employee_password, employee_role)
VALUES ('Alesya', 'Sergeeva', '1987-07-22', 'admin','1500', 'alesya1@mail.ru', 'uuu7', '1234','0');

###2
create table employees ( employee_name varchar (40), employee_surname varchar (40), 
employee_date_of_birth date, employee_profession varchar (40), employee_salary int (20), employee_email varchar (20) not null, 
employee_login varchar (20) not null unique, employee_password varchar (20), employee_role int (3) default 2, primary key (employee_login)); 
INSERT INTO employees (employee_name, employee_surname, employee_date_of_birth, employee_profession, employee_salary, employee_email, employee_login, employee_password)
VALUES ('Anna', 'Guchik', '1985-09-12', 'povar','1000', 'anna@mail.ru', 'uuu4', '1234');

 INSERT INTO employees (employee_name, employee_surname, employee_date_of_birth, employee_profession, employee_salary, employee_email, employee_login, employee_password)
VALUES ('Alesya', 'Sergeeva', '1987-07-22', 'worker','500', 'alesya1@mail.ru', 'uuu7', '1234');
 INSERT INTO employees (employee_name, employee_surname, employee_date_of_birth, employee_profession, employee_salary, employee_email, employee_login, employee_password)
VALUES ('Igor', 'Sydorov', '1988-03-15', 'povar','1000', 'igor@mail.ru', 'uuu8', '1234');
INSERT INTO employees (employee_name, employee_surname, employee_date_of_birth, employee_profession, employee_salary, employee_email, employee_login, employee_password)
VALUES ('Victor', 'Petrov', '1977-09-22', 'povar','1000', 'victor@mail.ru', 'uuu9', '1234');
 INSERT INTO employees (employee_name, employee_surname, employee_date_of_birth, employee_profession, employee_salary, employee_email, employee_login, employee_password)
VALUES ('Nikolay', 'Ivanov', '1990-11-30', 'worker','3000', 'nikolay@mail.ru', 'uuu10', '1234');
UPDATE employees SET employee_salary = 500 WHERE employee_login = 'uuu10';
INSERT INTO employees (employee_name, employee_surname, employee_date_of_birth, employee_profession, employee_salary, employee_email, employee_login, employee_password)
VALUES ('Lidya', 'Koshkina', '1993-12-25', 'worker','500', 'lidya@mail.ru', 'uuu11', '1234');

create table employee_vacation (id_vacation int (40) not null auto_increment,employee_vacation_fc varchar (40) not null, vacation varchar (40), primary key (id_vacation), foreign key (employee_vacation_fc) references employees (employee_login)); 

insert into employee_vacation ( employee_vacation_fc,vacation) values ('uuu10','22.10.19-30.10.19');
insert into employee_vacation ( employee_vacation_fc,vacation) values ('uuu7','20.08.20-25.09.20');
insert into employee_vacation ( employee_vacation_fc,vacation) values ('uuu10','03.06.20-15.06.20');

create table employee_vacation (id_vacation int (40) not null auto_increment,employee_login varchar (40) not null, vacation varchar (40), primary key (id_vacation), foreign key (employee_login) references employees (employee_login)); 

insert into employee_vacation ( employee_login,vacation) values ('uuu10','22.10.19-30.10.19');
insert into employee_vacation ( employee_login,vacation) values ('uuu7','20.08.20-25.09.20');
insert into employee_vacation ( employee_login,vacation) values ('uuu10','03.06.20-15.06.20');

create table employee_vacation (employee_login varchar (40) not null, vacation varchar (40), primary key (employee_login), foreign key (employee_login) references employees (employee_login)); 

insert into employee_vacation ( employee_login,vacation) values ('uuu10','22.10.19-30.10.19');
insert into employee_vacation ( employee_login,vacation) values ('uuu7','20.08.20-25.09.20');

create table employee_vacation (employee_login varchar (40) ,vacation varchar (40) ,   constraint primary key(employee_login), constraint foreign key (employee_login) references employees (employee_login)); 

create table employee_vacation(id int (100) not null auto_increment, employee_login varchar (40) not null ,vacation varchar (40) ,   constraint primary key(id), constraint foreign key (employee_login) references employees (employee_login));
create table employee_recommendations (id_employee_recommendations int (100) not null auto_increment, employee_login varchar (40) , recommendations varchar (200), constraint primary key (id_employee_recommendations), constraint foreign key (employee_login) references employees (employee_login));