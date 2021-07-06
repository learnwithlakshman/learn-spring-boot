drop table if exists trainer  CASCADE;
drop table if exists student CASCADE;
drop table if exists address CASCADE;
drop table if exists batch CASCADE;
drop table if exists student_batch CASCADE;
drop table if exists fee_details CASCADE;

create table trainer(id serial primary key,name varchar(100),email varchar(100));
insert into trainer(id,name,email) values(1,'Sai','sai@gmail.com');
insert into trainer(id,name,email) values(2,'Manoj','manoj@gmail.com');
insert into trainer(id,name,email) values(3,'Asha','asha@gmail.com');

create table student(id serial primary key,name varchar(100),qualification varchar(100));
insert into student(id,name,qualification) values(10,'Sujith','B.Tech');
insert into student(id,name,qualification) values(11,'Mahesh','B.Tech');
insert into student(id,name,qualification) values(12,'Ramesh','B.Tech');


create table address(id serial primary key,city varchar(100),student_id int references student(id));
insert into address(id,city,student_id) values(100,'Bangalore',10);
insert into address(id,city,student_id) values(101,'Mumbai',11);
insert into address(id,city,student_id) values(102,'Amaravathi',12);

create table batch(id serial primary key,name varchar(100),trainer_id int references trainer(id),fee float);
insert into batch(id,name,trainer_id,fee) values(1001,'Java',1,10000);
insert into batch(id,name,trainer_id,fee) values(1002,'Java',1,10000);
insert into batch(id,name,trainer_id,fee) values(1003,'Salesforce',2,20000);
insert into batch(id,name,trainer_id,fee) values(1004,'.Net',3,15000);

create table student_batch(s_id int references student(id),b_id int references batch(id));
insert into student_batch(s_id,b_id) values(10,1001);
insert into student_batch(s_id,b_id) values(10,1002);
insert into student_batch(s_id,b_id) values(11,1004);
insert into student_batch(s_id,b_id) values(12,1001);
insert into student_batch(s_id,b_id) values(12,1002);
insert into student_batch(s_id,b_id) values(11,1003);

create table fee_details(id serial primary key,amount float,s_id int references student(id),b_id int references batch(id));
insert into fee_details(id,amount,s_id,b_id) values(111,5000,10,1001);
insert into fee_details(id,amount,s_id,b_id) values(112,10000,10,1002);
insert into fee_details(id,amount,s_id,b_id) values(113,80000,11,1004);
insert into fee_details(id,amount,s_id,b_id) values(114,5000,11,1001);
insert into fee_details(id,amount,s_id,b_id) values(115,8000,12,1002);
insert into fee_details(id,amount,s_id,b_id) values(116,9000,11,1003);
