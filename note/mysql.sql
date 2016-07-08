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

-- employee 中添加image列
alter table employee add (`image` blob);
-- 修改job列 使其长度为60
alter table employee modify `job` varchar(60);
-- 删除sex列
alter table employee drop `sex`; 
-- 表名改为user
rename table employee to `user`;
-- 修改表的字符集为utf8
alter table user character set utf8;
-- 列名name改成username
alter table user change column name username varchar();

-- insert 
-- 添加数据
insert into `user` (`id`, `username`, `brithday`, `entry_date`, `job`, `salary`, `resume`) values (1, 'aa', '2011-01-23', '2015-12-12', 'web', '1239.12', '一个好人！');

-- update 
-- 所有员工薪水改为5000元
update `user` set salary = 5000;
-- 将姓名为‘zs’的员工的薪水改为3000
update `user` set salary = 3000 where username = 'zs';
-- 将姓名为‘aaa’的员工的薪水改为4000元，job改为ccc
update `user` set salary = 4000 and job = 'ccc' where username='aaa';
-- 将wu的薪水再原来基础上增加1000元
update `user` set salary = salary + 1000 where username = 'wu';

-- 删除表中名称为zs的记录
delete from `user` where usename = 'zs';
-- 删除表中所有记录
delete from `user`;

-- select
-- 查询所有学生信息
select * from student;
-- 查询所有学生的姓名和对应的英语成绩
select name, english from student;
-- 过滤重复的英语数据
select distinct english from student;
-- 在所有学生的总分上加10分
select name, (chinese + english + math) + 10 as s from student;
-- 查询王五的成绩
select * from student where `name` = '王五'
-- 英语成绩在80-90之间的
select * from student where english >= 80 and english <= 90;
select * from student where english between 80 and 90;
-- 查询数学分数是 80 90 91的人
select * from student where math in ('89', '90', '91');
-- 查询所有姓李的纪录
select * from student where name like '李%';

-- 统计班级语文、英语、数学各科的总成绩
select sum(chinese + english + math) from student;
-- 统计一个班级语文成绩的平均分
select avg(chinese) from student;
-- 班级总分平均分
select avg(chinese + english + math) from student;
-- 班级最高分和最低分
select max(chinese + english + math), min(chinese + math + english) from student;
-- 对订单表中商品归类后，显示每一类商品的总价
select product, sum(price) from orders group by product;
-- 查询购买了几类商品，并且没类总价大于100的商品
select product from orders group by product having sum(price)  > 100;
select product, sum(price) from orders group by product having sum(price)  > 100;
