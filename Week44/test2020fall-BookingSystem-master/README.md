```
These scripts have to be run to create the database and access it, necessary for getting the app to work
docker run -d --rm --name mysql-test-db -e MYSQL_ROOT_PASSWORD=testuser123 -p 3307:3306 mysql

docker exec -it mysql-test-db mysql -uroot -p

use mysql;

create table Customers ( ID int not null auto_increment, Firstname varchar(255) not null, lastname varchar(255), birthdate date, PRIMARY KEY (ID));

create table Employees ( ID int not null auto_increment, firstname varchar(255) not null, lastname varchar(255) not null, birthdate date, PRIMARY KEY (ID));

create table Bookings ( ID int not null auto_increment, customerId int not null, employeeId int not null, date Date not null, start Time not null, end Time not null, primary key (ID), foreign key (customerId) references Customers(ID) on delete cascade, foreign key (employeeId) references Employees(ID) on delete cascade );

insert into Customers(firstname, lastname) values( 'Carl', 'Carlson');

Here's the data migration commands.
create table CustomersPh ( ID int not null auto_increment, Firstname varchar(255) not null, lastname varchar(255), birthdate date, phonenumb varchar(255), PRIMARY KEY (ID));
Insert into CustomersPh(Firstname, lastname, birthdate) SELECT Firstname, lastname, birthdate FROM Customers;
ALTER TABLE Bookings DROP FOREIGN KEY Bookings_ibfk_1;
ALTER TABLE Bookings ADD FOREIGN KEY (customerId) references CustomersPh(ID) on delete cascade;
drop table Customers;
Rename TABLE CustomersPh TO Customers;
```
