drop table test;
create table test(
num int auto_increment primary key,
name varchar(10)
);
insert into test(name) values('1'),('2'),('3'),('4'),('5');
select * from test; -- 등록 확인용

delete from test; -- 전체삭제
insert into test(name) values('1'),('2'),('3'),('4'),('5');
select * from test; -- 삭제하고 실행하면 num이 6부터 실행된다

truncate table test;
insert into test(name) values('1'),('2'),('3'),('4'),('5'); 
select * from test; -- 삭제하고 실행하면 num이 1부터 실행된다


/*초기화 하는 법
방법1) delete 로 초기화 : 데이터만 삭제, 쓰던 공간은 그대로. AutoIncrement로 증가된 숫자 초기화 안됨
방법2) truncate로 초기화 : 최초로 테이블이 만들어졌던 상태로 돌림.
					   공간도 같이 삭제 , AutoIncrement로 증가된 숫자도 초기화
방법3) drop으로 초기화(삭제) : 테이블을 삭제, 제약조건 포함하여 모두 삭제
/*
