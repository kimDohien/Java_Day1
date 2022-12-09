-- test 데이터베이스 생성
-- create database test;
-- test 데이터베이스가 존재하지 않으면 test 데이터베이스 생성
create database if not exists test;
-- test 데이터베이스 선택
use test;
-- test 데이터베이스 삭제
-- drop database test;
-- test 데이터베이스가 존재하면 test 데이터베이스 삭제
-- drop database if exists test;
-- -_-+
-- member테이블 생성
-- 속성으로 id(최대문자열13,기본키), 비번(최대문자열 20), 이름을 가짐 
create table if not exists member(
	id varchar(13) primary key, 
    pw varchar(20) not null,
    name varchar(30) not null
);

-- 게시글 만듬
-- auto_increment(자동증가) : 기본키만 가능, 테이블당 최대 1개만 설정
create table if not exists board(
	num int auto_increment primary key,
    title varchar(50) not null,
    contents longtext not null,
    writer varchar(13) not null,
    foreign key(writer) references member(id)
);

-- board 테이블에 views 추가
alter table board add views int default 0;
-- board 테이블에 views 삭제
alter table board drop views;
-- board 테이블에 잘못된 views 추가
alter table board add views varchar(10);
-- board 테이블에 잘못된 views를 올바르게 수정
alter table board modify views int default 0;
-- board 테이블에 views 이름을 views2로 수정
alter table board change views views2 int default 0; 
-- board 테이블에 있는 writer 제약조건을 삭제
alter table board drop constraint board_ibfk_1;
-- board 테이블에 writer와 member테이블에 id를 외래키로 연결(제약조건 추가)
alter table board add constraint fk_board_writer foreign key(writer) references member(id);

-- 워크벤치에서 추가한 board2 테이블 삭제
drop table if exists board2;


