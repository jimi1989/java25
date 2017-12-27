-- 聚合函数，聚合函数会忽略所有的null和空值
SELECT count(prod_name) from products;
select count(cust_id) from customers;

select max(prod_price) from products;
select min(prod_price) from products;
select avg(prod_price) from products;

select max(prod_price),min(prod_price) from products;

select max(prod_price),prod_name from products;


select quantity * item_price as total 
from orderitems where order_num = 20005;

select sum(quantity * item_price ) as sumPrice
from orderitems where order_num = 20005;

-- 分组函数
select count(*) from products where vend_id = 1001;
select count(*) from products where vend_id = 1002;
select count(*) from products where vend_id = 1003;

-- 在分组之前进行过滤使用where子句
-- 在分组之后过滤使用having子句
select count(*) AS 'prod_size',vend_id from products 
where vend_id != 1005 group BY vend_id 
HAVING prod_size >= 3 ORDER BY prod_size DESC limit 0,1;


-- 子查询
-- 1.在orderitems表根据商品ID获得订单编号
select order_num from orderitems where prod_id = 'TNT2';
-- 2.在orders表根据ordernum获得cust_id
select cust_id from orders where order_num in (20005,20007);
-- 3.在customers表中根据cust_id获得cust_name
select cust_name from customers where cust_id in (10001,10004);

select cust_name from customers where cust_id in (
select cust_id from orders where order_num in (
select order_num from orderitems where prod_id = 'TNT2'));

select prod_id,prod_name,vend_id,
(select vend_name from vendors where vend_id = p.vend_id
) as vend_name from products as p;

select cust_id,cust_name,(
select count(*) from orders where cust_id = c.cust_id
) as ordernum from customers as c;


-- 等值查询
select s.id,s.name,c.name from t_stu as s,t_class as c 
where s.class_id = c.id;

select * from t_stu INNER JOIN t_class ON
t_stu.class_id = t_class.id;

select s.id,s.name,c.name from 
t_stu as s INNER JOIN t_class as c ON
s.class_id = c.id;

-- 左外连接
select s.id,s.name,c.name from 
t_stu as s LEFT JOIN t_class as c ON
s.class_id = c.id;

select s.id,s.name,c.name from 
t_class as c LEFT JOIN t_stu as s ON
s.class_id = c.id;

-- 右外连接

select s.id,s.name,c.name from 
t_stu as s RIGHT JOIN t_class as c ON
s.class_id = c.id;

-- 组合查询
select * from t_user
UNION ALL
select * from t_company
order by createtime desc;

insert into t_company(cname) 
select name from t_class;





