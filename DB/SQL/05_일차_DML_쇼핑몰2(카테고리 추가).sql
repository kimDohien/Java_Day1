INSERT INTO `shoppingmall_pro`.member(`me_id`,`me_pw`,`me_name`,`me_birth`,`me_authority`,`me_point`)values('abc','abc','ABC마트','MEMBER',0);
INSERT INTO `shoppingmall_pro`.member(`me_id`,`me_pw`,`me_name`,`me_birth`,`me_authority`,`me_point`)values('admin','admin','관리자','2003-05-01','MEMBER',	0);
INSERT INTO `shoppingmall_pro`.member(`me_id`,`me_pw`,`me_name`,`me_birth`,`me_authority`,`me_point`)values('hi','hi','곽두팔','2004-05-07','MEMBER',0);
INSERT INTO `shoppingmall_pro`.member(`me_id`,`me_pw`,`me_name`,`me_birth`,`me_authority`,`me_point`)values('qwe','	qwe','김도현','2000-01-01','MEMBER',0);

insert into main_category(mc_name) values('의류'),('식품'),('가전'),('스포츠'),('문구');
select*from main_category; -- 확인용

insert into sub_category(sc_name,sc_mc_num) select '여성', mc_num from main_category where mc_name ='의류';
insert into sub_category(sc_name,sc_mc_num) select '남성', mc_num from main_category where mc_name ='의류';
insert into sub_category(sc_name,sc_mc_num) select '아동', mc_num from main_category where mc_name ='의류';
insert into sub_category(sc_name,sc_mc_num) select '남녀공용', mc_num from main_category where mc_name ='의류';
insert into sub_category(sc_name,sc_mc_num) select '과일', mc_num from main_category where mc_name ='식품';
insert into sub_category(sc_name,sc_mc_num) select '채소', mc_num from main_category where mc_name ='식품';
insert into sub_category(sc_name,sc_mc_num) select '과자', mc_num from main_category where mc_name ='식품';
insert into sub_category(sc_name,sc_mc_num) select '쌀/잡곡', mc_num from main_category where mc_name ='식품';
insert into sub_category(sc_name,sc_mc_num) select 'TV', mc_num from main_category where mc_name ='가전';
insert into sub_category(sc_name,sc_mc_num) select '냉장고', mc_num from main_category where mc_name ='가전';
insert into sub_category(sc_name,sc_mc_num) select '에어컨', mc_num from main_category where mc_name ='가전';
insert into sub_category(sc_name,sc_mc_num) select '수영', mc_num from main_category where mc_name ='스포츠';
insert into sub_category(sc_name,sc_mc_num) select '골프', mc_num from main_category where mc_name ='스포츠';
insert into sub_category(sc_name,sc_mc_num) select '자전거', mc_num from main_category where mc_name ='스포츠';
insert into sub_category(sc_name,sc_mc_num) select '사무용품', mc_num from main_category where mc_name ='문구';
insert into sub_category(sc_name,sc_mc_num) select '미술용품', mc_num from main_category where mc_name ='문구';
select * from sub_category; -- 확인용

insert into address_book(ab_name, ab_address, ab_postnum, ab_me_id)
values('집','서울시 강남','12345','abc'),
('회사','서울시 강북','23456','abc'),
('집','경기도 안산','45678','hi'),
('회사','서울시 강북','23456','hi'),
('집','충북 청주','32145','qwe'),
('처가','서울시 강남','12345','qwe');
select * from address_book;  -- 확인용


insert into product(pr_name,pr_contents,pr_amount,pr_price,pr_sc_num)
values('반집업 맨투맨', '세컨그라운드 여성용 반집업 맨투맨', 10,17000,1),
('세미 크롭 맨투맨', '바블링브룩 여성용 세미 크롭 맨투맨', 10,19900,1),
('긴팔 카라티', '빅사이즈클럽 킨팔 카라티', 20, 24900,2),
('7부 브이넥 티셔츠 ', '해리슨 남성용 브이넥 7부 티셔츠', 20, 24900,2),
('기모조거팬츠','우드피카 기모 조거팬츠', 5, 24800,4),
('슬롭 스키니', '블랙 기모 슬림 스키니', 100,51840,4);

select *from product;
insert into product_option(po_title,po_amount,po_pr_num) 
values ('빨강',5,1),('노랑',5,1),('흰색',5,1),
('S',5,2),('M',5,2),('L',5,2),
('흰색 S',5,3),('흰색 M',5,3),('흰색 L',5,3),('남색 S',5,3),('남색 M',5,3),('남색 L',5,3),
('XS',5,4),('S',5,4),('M',5,4),('L',5,4),('XL',5,4),
('24인치',5,5),('26인치',5,5),('28인치',5,5),('30인치',5,5),('32인치',5,5),
('60cm',5,6),('64cm',5,6),('68cm',5,6),('72cm',5,6);



