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
insert into product values('p185','name14','blabla','12000','2','5','3','0','pants');
insert into product values('p186','name15','blabla','12000','2','5','3','0','pants');
insert into product values('p187','name16','blabla','12000','2','5','3','0','pants');
insert into product values('p188','name17','blabla','13000','2','5','3','0','pants');
insert into product values('p189','name18','blabla','12000','2','5','3','0','pants');
insert into product values('p190','name19','blabla','11000','2','5','3','0','pants');
insert into product values('p191','name20','blabla','15000','2','5','3','0','pants');
insert into product values('p192','name21','blabla','12000','2','5','3','0','pants');

insert into product values('p193','name22','blabla','12000','2','5','3','0','shirts');
insert into product values('p194','name23','blabla','12000','2','5','3','0','shirts');
insert into product values('p195','name24','blabla','12000','2','5','3','0','shirts');
insert into product values('p196','name25','blabla','12000','2','5','3','0','shirts');
insert into product values('p197','name26','blabla','12000','2','5','3','0','shirts');
insert into product values('p198','name27','blabla','12000','2','5','3','0','shirts');
insert into product values('p199','name28','blabla','12000','2','5','3','0','shirts');
insert into product values('p200','name29','blabla','12000','2','5','3','0','shirts');

insert into addcart values('id1212','p123','small','3');
insert into addcart values('id1212','p223','small','2');
insert into addcart values('id1212','p153','small','1');

insert into member values('id4432','pwpw1','hong','010-8785-1257','서울 종로구 아으아으아');
insert into member values('id2341','pwpw2','kim','010-2652-1257','서울 종로구 헤헤');
insert into member values('id1128','pwpw3','kdh','010-7854-3325','서울 종로구 우우ㅜㅏㅇㄷ');
insert into member values('id6432','pwpw4','qwea','010-8931-1356','서울 종로구 자ㅣ더사ㅣㅈ');
insert into member values('id3343','pwpw5','lee','010-3532-6542','서울 종로구 아러ㅏ니니');
insert into member values('id1211','pwpw6','hwang','010-1479-6432','서울 종로구 ㅈㅂ돠ㅡㅁㄴ');
insert into member values('id6579','pwpw7','won','010-1257-6432','서울 종로구 ㅇ나럽ㅈㄱ');
insert into member values('id9865','pwpw8','dh','010-1478-7644','서울 종로구 ㅇ나ㅣ룁ㅈ');
insert into member values('id0252','pwpw9','sh','010-7954-3544','서울 종로구 야좁고멂');
insert into member values('id0643','pwpw0','bj','010-3457-7663','서울 종로구 버라보뱝');

select * from product;

create table purchaselist(
     id varchar(20)  ,
     name varchar(20),
     sizeS int(5),
     sizeM int(5),
     sizeL int(5),  
     sizeXL int(5),
     price int(20),
     reCheck varchar(5),
     pId int(5) primary key
     );
     Foreign key (id) references member (id);
     
     
     
create table orderlist(
	id varchar(20),
	name varchar(20),
	sizeS int(5),
	sizeM int(5),
	sizeL int(5),
	sizeXL int(5),
	price int(10),
	pId varchar(10) primary key,
	transName varchar(20),
	transNum varchar(10),
	foreign key (id) references member (id)
	);
	
	
insert into member values('awqe323','asdwq1','ourname','010-5454-1231','경기 화성시 헤헤헤헤','871108-1832433', 0);
insert into member values('fasf346','urty3','ourname','010-5454-1231','경기 화성시 헤헤헤헤','811108-2832433', 0);
insert into member values('asdgag45','dfg4','ourname','010-5454-1231','경기 화성시 헤헤헤헤','791108-1832433', 0);
insert into member values('vxczwer1','we13434','ourname','010-5454-1231','경기 화성시 헤헤헤헤','921108-2832433', 0);
insert into member values('sdfagadfag','erery8956','ourname','010-5454-1231','경기 화성시 헤헤헤헤','041108-1832433', 0);
insert into member values('asdgfdge45','sdfgre32','ourname','010-5454-1231','경기 화성시 헤헤헤헤','931108-2832433', 0);
insert into member values('agdf2','scvxb3','ourname','010-5454-1231','경기 화성시 헤헤헤헤','911108-2832433', 0);
insert into member values('asdfwe2','wqdgs33','ourname','010-5454-1231','경기 화성시 헤헤헤헤','011108-1832433', 0);
insert into member values('dfbhfdngfh5','werwe3a','ourname','010-5454-1231','경기 화성시 헤헤헤헤','971108-1832433', 0);
insert into member values('ertrwui2','sdfewr345','ourname','010-5454-1231','경기 화성시 헤헤헤헤','831108-2832433', 0);
insert into member values('rtret32','sdfewr345','ourname','010-5454-1231','경기 화성시 헤헤헤헤','731108-1832433', 0);
insert into member values('cvbcx6','sdfewr345','ourname','010-5454-1231','경기 화성시 헤헤헤헤','691108-2832433', 0);
insert into member values('tryrthgf56','sdfewr345','ourname','010-5454-1231','경기 화성시 헤헤헤헤','671108-2832433', 0);
insert into member values('rewy77','sdfewr345','ourname','010-5454-1231','경기 화성시 헤헤헤헤','861118-1832433', 0);
insert into member values('xcvbd4','sdfewr345','ourname','010-5454-1231','경기 화성시 헤헤헤헤','931108-2832433', 0);
insert into member values('qwsdfg2','sdfewr345','ourname','010-5454-1231','경기 화성시 헤헤헤헤','101108-1832433', 0);
insert into member values('ertrtw324','sdfewr345','ourname','010-5454-1231','경기 화성시 헤헤헤헤','091108-1832433', 0);
insert into member values('kyuli74','sdfewr345','ourname','010-5454-1231','경기 화성시 헤헤헤헤','031108-1832433', 0);
insert into member values('ghjkhjk99','sdfewr345','ourname','010-5454-1231','경기 화성시 헤헤헤헤','081108-1832433', 0);
insert into member values('dfhddi90','sdfewr345','ourname','010-5454-1231','경기 화성시 헤헤헤헤','061108-1832433', 0);