create table product(
	pId varchar(20) primary key,
	name varchar(40),
	explanation varchar(50),
	price varchar(30),
	sizeS varchar(30),
	sizeM varchar(30),
	sizeL varchar(30),
	sizeXL varchar(30),
	kind varchar(30)
);

insert into product values('1','드롭 숄더 싱글 코트[블랙]','235df', '3500','2','4','5','6','men',null);
insert into product values('2','드롭 숄더 더플 코트[네이비]','ewt2tefk', '4500','2','4','5','6','men',null);
insert into product values('3','핸드메이드 체스터 코트 [카멜]','fsdgcjsk', '5500','2','4','5','6','men',null);
insert into product values('4','드롭 숄더 싱글 코트[라이트 그레이]','asdfsk', '6630','2','4','5','6','men',null);
insert into product values('5','헤비 울 체크 더플 코트 [그린]','qwetk', '67500','2','4','5','6','men',null);
insert into product values('6','런던 헤비 러프 울 로브-코트','grety', '45500','2','4','5','6','women',null);
insert into product values('7','프리미엄 핸드메이드 후드 롱 코트 [헤링본 브라운]','asdsdf', '75650','2','4','5','6','women',null);
insert into product values('8','우주 오버 롱 싱글 코트 하운드투스 체크','asdsdf', '75650','2','4','5','6','women',null);
insert into product values('9','프리미엄 파리스 프린티드 후디 코트[아이보리]','asdsdf', '75650','2','4','5','6','women',null);
insert into product values('10','스무스 울 싱글 코트-네이비','asdsdf', '75650','2','4','5','6','women',null);
insert into product values('11','따뜻한 롱다운 CKJD18N1B','asdsdf', '75650','2','4','5','6','kids',null);
insert into product values('12','4단 변신 벤치다운_OHJD19B01','asdsdf', '75650','2','4','5','6','kids',null);
insert into product values('13','체크후디 퀼팅코트 LBJC18BH1','asdsdf', '75650','2','4','5','6','kids',null);
insert into product values('14','LOCATION LOGO CREWNECK HA [INDIGO BLUE]','asdsdf', '75650','2','4','5','6','men',null);
insert into product values('15','[18FW] WALK SLOW SWEATSHIRT[블랙]','asdsdf', '75650','2','4','5','6','women',null);
insert into product values('16','크리킷 오버핏 맨투맨 티셔츠','asdsdf', '75650','2','4','5','6','men',null);

create table addcart(
uid varchar(20),
pid varchar(20),
size varchar(20),
count varchar(20)
);

create table checkout(
uid varchar(20),
pid varchar(20),
size varchar(20),
count varchar(20)
);

create table recommend(
pid varchar(20),
count varchar(30)
);

