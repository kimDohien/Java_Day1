create database if not exists shoppingmall_pro;
use shoppingmall_pro;

create table if not exists member( -- 회원
	me_id varchar(15) primary key,
	me_pw varchar(15) not null,
	me_name varchar(15) ,
	me_birth date ,
	me_authoity varchar(15) not null default 'MEMBER',
	me_point int not null default 0
);

create table if not exists main_category( -- 대분류
mc_num int auto_increment primary key,
mc_name varchar(20) not null
);

create table if not exists sub_category( -- 중분류
sc_num int auto_increment not null primary key,
sc_name varchar(20) not null,
sc_mc_num int,
foreign key(sc_mc_num) references main_category(mc_num)
);

create table if not exists product( -- 제품
pr_num int auto_increment not null primary key,
pr_name varchar(20) not null,
pr_contents longtext not null,
pr_reg_date datetime not null default now(),
pr_amount int not null default 0,
pr_price int not null default 0,
pr_sc_num int not null,
foreign key(pr_sc_num) references sub_category(sc_num)
);

create table if not exists product_option( -- 옵션
po_num int auto_increment not null primary key,
po_title varchar(50) not null,
po_amount int not null default 0,
po_pr_num int not null,
foreign key(po_pr_num) references product(pr_num)
);

create table if not exists address_book( -- 주소록
ab_num int auto_increment not null primary key,
ab_name varchar(15) not null, -- 주소록 이름
ab_address varchar(100) not null,
ab_postnum char(5) not null,
ab_me_id varchar(15) not null,
foreign key(ab_me_id) references member(me_id)
);

create table if not exists basket(
ba_num int auto_increment primary key,
ba_amount int not null default 0,
ba_me_id varchar(15) not null,
ba_po_num int not null,
foreign key(ba_me_id) references member(me_id),
foreign key(ba_po_num) references product_option(po_num)
);

create table if not exists `order`( -- 주문내역
or_num int auto_increment primary key, -- 결제번호
or_total_price int not null,
or_price int not null, -- 실제 가격
or_use_point int not null,
or_add_point int not null,
or_state varchar(15) not null default '결제완료',
or_me_id varchar(15) not null,
or_ab_num int not null,
foreign key(or_ab_num) references address_book(ab_num),
foreign key(or_me_id) references member(me_id)
);

create table if not exists order_list( -- 주문리스트
ol_num int auto_increment primary key,
ol_amount int not null,
ol_price int not null,
ol_or_num int not null,
ol_po_num int not null,
foreign key(ol_or_num) references `order`(or_num),
foreign key(ol_po_num) references product_option(po_num)
);
