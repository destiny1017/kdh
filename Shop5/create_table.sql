create table member(
     id varchar(20) primary key,
     pw varchar(20),
     name varchar(20),
     tel varchar(20),
     address varchar(100)
     );
     
create table product(
   pId varchar(20) primary key,
   name varchar(20),
   explanation varchar(50),
   price varchar(30),
   sizeS varchar(30),
   sizeM varchar(30),
   sizeL varchar(30),
   sizeXL varchar(30)
);

insert into product values('p123','name1','blabla','10000','2','1','1','0','outer');
insert into product values('p223','name2','blabla','10000','4','3','0','0','pants');
insert into product values('p153','name3','blabla','10000','1','4','2','0','shirts');
insert into product values('p322','name4','blabla','10000','1','3','1','0','outer');
insert into product values('p175','name5','blabla','10000','2','5','3','0','pants');
insert into product values('p176','name6','blabla','10000','2','5','3','0','pants');
insert into product values('p177','name7','blabla','15000','2','5','3','0','pants');
insert into product values('p178','name8','blabla','10000','2','5','3','0','pants');
insert into product values('p179','name9','blabla','10000','2','5','3','0','pants');
insert into product values('p180','name10','blabla','11000','2','5','3','0','pants');
insert into product values('p181','name11','blabla','10000','2','5','3','0','pants');
insert into product values('p182','name12','blabla','13000','2','5','3','0','pants');
insert into product values('p184','name13','blabla','10000','2','5','3','0','pants');
insert into product values('p183','name14','blabla','12000','2','5','3','0','pants');


insert into addcart values('id1212','p123','small','3');
insert into addcart values('id1212','p223','small','2');
insert into addcart values('id1212','p153','small','1');


