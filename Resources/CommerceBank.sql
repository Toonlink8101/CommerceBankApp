/* Save and run the entire script in one file */
/* Run this from the root */

drop database if exists commerce;
create database commerce;

use commerce;

drop table if exists users;
drop table if exists calendar;

create table users(
  u_id int not null AUTO_INCREMENT,
  username varchar(50), 
  password varchar(50), 
  first_name varchar(30), 
  constraint pkusers primary key (u_id));

ALTER TABLE users AUTO_INCREMENT=100;

create table calendar(
    c_id int(10) not null,
    u_id int(10) not null,
    amount decimal(10,2) DEFAULT NULL,
    transactionTime date,
    constraint pkcalendar primary key (c_id));

ALTER TABLE calendar ADD CONSTRAINT calendar_FK FOREIGN KEY (u_id) REFERENCES users(u_id);

INSERT INTO `users` (username,password,first_name) VALUES ('Bobsmith','1234','Bob'),('Mary','admin','Mary'),('customer1','1234','Chris');
