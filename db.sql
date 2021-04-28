/*
-- SQL Server
if not exists(select * from sys.databases where name = 'test') begin
	create database test
	print 'test created'
end
go
use test
go
if not exists(select * from sys.tables where name = 'customer') begin
	create table customer  (id int not null, name nvarchar(50))
end
if not exists(select * from customer) begin
	insert into customer (id, name) values (1, N'魏红记'), (2, N'张青峰'), (3, N'张三'), (4, N'SQL Server')
end
*/

-- MySQL
create database if not exists test;
use test;

create table if not exists customer (id int not null, name varchar(50));

delimiter //
insert into customer (id, name)
select * from (
	select 1 as id, '魏红记' as name
	union select 2, '张青峰'
	union select 3, '张三'
	union select 4, 'MySQL'
) x
where not exists(select * from customer);
//
delimiter ;

/*
select * from customer;
*/