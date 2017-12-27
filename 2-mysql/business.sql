-- 1.  用户注册
insert into t_member (nickname,name,email,address,tel,zip,password)
values ('snow','雪诺','snow@qq.com','king of north','13596325874','455000','123456');
-- 2.  用户登录
select * from t_member where nickname = 'snow' and password = '123456';
-- 3.  查看计算机类所有书籍
select * from t_book where typeid in 
(select id from t_type where pid = 3);	

select * from t_book b, t_type t where 
b.typeid = t.id and t.pid = 3;

-- 4．根据一本书籍的主键，获取书籍的名称、价格、出版社名称、作家名称
	-- 4.1 等值查询

select b.bookname ,b.price , p.publishname,a.`name` 
from t_book b ,t_publish p, t_author a 
where b.publish_id = p.id and b.author_id = a.id 
and b.id = 5;
	-- 4.2 内连接
select b.bookname ,b.price , p.publishname,a.`name` 
from t_book b inner JOIN t_publish p 
on b.publish_id = p.id 
inner JOIN t_author a
on b.author_id = a.id
where b.id = 5;

-- 5． 获取一个作家所著的所有书籍
select * from t_book where author_id = (
select id from t_author where name = '吴承恩');

-- 6． 查看一个会员收藏的书籍
select b.bookname from t_fav f,t_member m, t_book b 
where f.mid = m.id and f.bid = b.id
and m.nickname = 'java007';
-- 7.  写出书籍表的分页 SQL（每页 3 条书籍），写出输出第一页和第三页的
select * from t_book LIMIT 0,3;
select * from t_book limit 6,3;

-- 8． 修改一个会员的密码
update t_member set password = '12345' 
where nickname = 'snow' and `password` = '123456';

-- 9.  写出一本书籍对应的评论及评论的会员姓名
select c.content,b.bookname,m.nickname from
t_commentary c left JOIN t_book b
on c.bid = b.id 
left join t_member m
on c.mid = m.id
where b.bookname = 'oracle从精通到入门';

-- 10．	查询一个订单对应的书籍
select b.bookname from t_order_book ob ,t_book b
where ob.bid = b.id
and oid = 2;

-- 11．	统计一个月内计算机类书籍的销售总额b.type_id , t.pid ,ROUND(SUM(b.price),2)
select ROUND(sum(b.price),2) from t_order_book ob
left join t_book b on ob.bid = b.id
left JOIN t_order o  on ob.oid = o.id
left JOIN t_type t on b.typeid = t.id
where pid = 3 and o.state = '已完成' 
and DATEDIFF('2016-10-30',o.otime) <=30;


-- 12．	统计两个月内各类书籍的销售额
select ROUND(sum(b.price),2),t.pid,
(select name from t_type where id = t.pid) as '类型'
 from t_order_book ob
left JOIN t_book b on ob.bid = b.id
left JOIN t_order o  on ob.oid = o.id
left JOIN t_type t on b.typeid = t.id
where o.state = '已完成' 
and DATEDIFF('2016-10-30',o.otime) <=60
GROUP BY t.pid;


-- 13．	统计两个月内各类书籍的销售数量
select count(*),t.pid,
(select name from t_type where id = t.pid) as '类型'
 from t_order_book ob
left JOIN t_book b on ob.bid = b.id
left JOIN t_order o  on ob.oid = o.id
left JOIN t_type t on b.typeid = t.id
where o.state = '已完成' 
and DATEDIFF('2016-10-30',o.otime) <=60
GROUP BY t.pid;


-- 14．	删除一个用户对应的所有评论
delete from t_commentary where mid = (
SELECT id from t_member where nickname = 'kobe_lover');
	
-- 15．	列出总销量前五名的书籍 

select count(*) as salenum,b.bookname from 
t_order_book ob ,t_book b
where ob.bid = b.id GROUP BY b.bookname
order by salenum desc limit 0,5;

-- 16．	列出总销量前三名的书籍分类
	select count(*) as salenum,t.pid,
(select name from t_type where id = t.pid) as '类型'
from t_order_book ob ,t_book b, t_type t
where ob.bid = b.id and b.typeid = t.id
group by t.pid order by salenum desc limit 0,3;


-- 17．	列出计算机类别中销售前三名的书籍
	SELECT count(*) ,ob.bid,
	b.bookname 
	from t_order_book ob INNER JOIN 
	t_book b on ob.bid = b.id
	INNER JOIN t_type t ON b.typeid = t.id
	WHERE t.pid = 3 GROUP BY (bid)
	ORDER BY count(*) DESC,bid limit 0,3;

-- 18．	列出《一本书》（随意名字）的销售量
	SELECT COUNT(*),b.bookname FROM t_order_book ob ,t_book b 
	where ob.bid = b.id AND b.bookname='西游记';
-- 19．	列出书籍总销量前三名的作者 
	select COUNT(*) as 'salenum',a.name
	FROM t_order_book ob ,t_book b,t_author a 
	where ob.bid = b.id AND b.author_id = a.id
	GROUP BY (ob.bid) 
	ORDER BY salenum DESC,bid ASC LIMIT 0,3;
-- 20．	搜索“张三”（随意名字）所著的书籍
	select b.bookname,a.`name` from t_book b ,t_author a where 
	b.author_id = a.id AND a.name='周志明';
-- 21．	搜索书籍名称中含有“java”的书籍
	select * FROM t_book where bookname like '%java%';
-- 22．	获取书籍名称中含有“java”的书籍的数量
	select count(*) FROM t_book where bookname like '%java%';
-- 23．	获取一本书籍的评论数量
	SELECT count(*) from t_commentary c, t_book b 
	WHERE	c.bid = b.id AND b.bookname = '西游记';