
create table member(
	id varchar(30) primary key,
	name varchar(30) not null,
	age int(10),
	tel varchar(50)
);

insert into member values('1212','wqeqw','20','wqe1');
insert into member values('id200','1','1','1');
insert into member values('id400','nananame','23','wqeqwr');
insert into member values('idid1212','name2','43','012031');


update member set tel = '010-1234-4321' where id = 'id400';

delete from member where id = 'id200';

select * from member;
select * from member where id = '1212';

