create database LOGIN_FORM
create table USER_ACCOUNT
(
USER_NAME VARCHAR(30) not null,
PASSWORD  VARCHAR(30) not null,
primary key (USER_NAME)
);
create table INFO
(
CODE  VARCHAR(20) not null,
REALNAME  VARCHAR(128) not null,
GENDER VARCHAR(1) not null,
primary key (CODE)
) ;
 
-- Insert data: ---------------------------------------------------------------
 
insert into user_account (USER_NAME, PASSWORD)
values ('tom', 'tom001');
 
insert into user_account (USER_NAME, PASSWORD)
values ('jerry', 'jerry001');
 
insert into info (CODE, REALNAME, GENDER)
values ('P001', 'TOM CAT', 'M');
 
insert into info (CODE, REALNAME, GENDER)
values ('P002', 'JERRY MOUSE', 'M');
