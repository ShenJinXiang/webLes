-- 创建名称为mydb1的数据库
create databases if not exsits mydb1 character set 'utf8';

-- 修改数据看字符集为gb2312
alter database mydb1 character set gb2312

-- 创建员工表
create table employee(
	id int,
	name varchar(100),
	sex bit(1),	-- sex varchar(4),
	brithday date,
	entry_date date,
	job varchar(100),
	salary float(10,2),
	resume text
);

-- 查看所有表
show tables;

show create table table_name;

desc table_name;
