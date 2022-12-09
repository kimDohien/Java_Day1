-- drop database if exists shoppingmall;
create database if not exists shoppingmall;
use shoppingmall;

-- drop table if exists member;
create table if not exists member(
	me_id varchar(13) primary key not null, -- 아이디
    me_pw varchar(30) not null, -- 비번
    me_authority varchar(6) not null default 'MEMBER', -- 권한 : 회원(member),관리자(Admin)
    me_name varchar(20) not null, -- 이름
    me_birth date not null -- 생년월일
);

create table if not exists board_category(
	bc_num int auto_increment primary key, -- 게시글 카테고리 번호
	bc_name varchar(10) not null -- 게시글 카테고리명
);

create table if not exists board(
bo_num int auto_increment primary key, -- 게시글 번호
bo_title varchar(10) not null, -- 게시글 제목
bo_contents longtext not null, --  게시글 내용
bo_reg_date datetime not null default now(), -- 게시글 등록일, now() : 현재 시간을 호출해줌
bo_views int not null default 0, -- 게시글 조회수
bo_me_id varchar(13) not null, -- 게시글 작성자
bo_bc_num int not null, -- 게시글 카테고리번호
constraint fk_me_id foreign key(bo_me_id) references member(me_id),
constraint fk_bo_bc_num foreign key(bo_bc_num) references board_category(bc_num)
);

create table if not exists product_category(
pc_num int auto_increment primary key,
pc_name varchar(10) not null
);

create table if not exists product(
	pr_Num int auto_increment primary key, -- 제품번호
	pr_title varchar(50) not null, -- 제품명
	pr_contents longtext not null, -- 제품상세
	pr_amount int not null default 0, -- not null을 체크해야 기본값이 들어간다
	pr_price int not null, -- 가격
    pr_pc_num int not null,
    constraint fk_pr_pc_num foreign key(pr_pc_num) references product_category(pc_num)
);

create table if not exists buy(
buy_num varchar(20) primary key , -- 구매번호(결재번호)
buy_status varchar(10) not null default '결재 완료', -- 구매상태
buy_amount int not null default 1, -- 구매수량 , 최소1개구매 
buy_price int not null,
buy_address varchar(50) not null, -- 주소
buy_post_num varchar(5) not null,
buy_me_id varchar(13) not null, -- 구매아이디
buy_pr_num int not null, -- 구매 제품 번호
constraint fk_buy_pr_num foreign key(buy_pr_num) references product(pr_num),
constraint fk_buy_me_id foreign key(buy_me_id) references member(me_id)

);

create table if not exists inquiry(
in_num int auto_increment primary key ,
in_contents longtext not null,
in_pw char(4), -- 문의비번
in_reply longtext, -- 문의답변
in_me_id varchar(13) not null,-- 문의 아이디
in_pr_num int not null, -- 문의제품
constraint fk_in_pr_num foreign key(in_pr_num) references product(pr_num),
constraint fk_in_me_id foreign key(in_me_id) references member(me_id)

);
