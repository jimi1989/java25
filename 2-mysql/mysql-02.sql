insert into t_emp (name,age,address) VALUES
('rose',24,'焦作'),('james',20,'新乡')
,('张三丰',99,'武当山');

update t_emp SET name = '张翠山' where id = 5;
update t_emp SET name = '周芷若',age = 18,address='峨眉'
where id = 4;

-- update t_emp SET name = '赵敏' where id = 32 or id = 12 or id = 2 or id = 3;
update t_emp SET name = '赵敏' where id in (32,12,2,3);
update t_emp set age = 19 where age BETWEEN 20 and 23; 

delete from t_emp where id <= 3;

truncate table t_stu; -- delete from t_stu;

alter table t_user add schoolid int;

alter TABLE t_user add CONSTRAINT fk_t_user_school_id
FOREIGN KEY (schoolid) REFERENCES t_school(id);

update t_user set schoolid = 4 where id =6;

alter table t_user drop FOREIGN key fk_t_user_school_id;fk_t_user_school_id;

