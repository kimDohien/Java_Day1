/*(제품 카테고리 추가)
가전 , 의류, 식품, 취미용품, 애견용품
*/
insert into product_category(pc_name) values('가전'),('의류'),('식품'),('취미용품'),('애견용품');
select * from product_category; -- 확인용

/*(카테고리 내용 추가)
가전 , 50인치 tv , 50인치 TV판매, 10대, 10000원
가전 , 100인치 tv , 100인치 TV판매, 20대, 20000원
가전 , 무풍 에어컨 , 무풍 에어컨 판매, 3대, 30000원
의류 , 셔츠 , 겨울용 셔츠 판매, 15벌, 1000원
식품 , 스테이크 , 부드러운 스테이크 판매, 40개, 5000원
취미용품 , 등산화 , 안전한 등산화 판매, 5개, 5000원
애견용품 , 개껌, 오래가는 개껌 판매 , 3개, 10000원
*/
insert into product(pr_title, pr_contents,pr_amount,pr_price,pr_pc_num)
values ('50인치 TV', '50인치 TV판매', 10,10000,1),
('100인치 tv', '100인치 TV판매', 20,20000,1),
('무풍 에어컨', '무풍 에어컨 판매', 3,30000,1),
('셔츠', '겨울용 셔츠 판매', 15,1000,2),
('스테이크', '부드러운 스테이크 판매', 40,5000,3),
('등산화', '안전한 등산화 판매', 5,5000,4),
('개껌', '오래가는 개껌 판매', 3,10000,5);
select*from product;

select*from member;
/* abc회원이 50인치 TV 1대를 구매 함. 주소는 서울시 강남, 우편번호는 12345
이때 실행되어야 하는 쿼리 작성 */
-- buy 테이블, insert문
insert into buy values
('abc1','결제완료',1,'서울시 강남','12345','abc',1);
select*from buy;
-- product 테이블, update문
update product 
	set
    pr_amount = pr_amount -1
    where pr_num = 1;
select*from product;


/*
-insert values 문 => 추가하는 값들을 모두 알고있는 경우 사용
insert into 테이블명 values();

-insert select문 => 일부 값들을 검색을 통해 가져와야 하는 경우
insert into 테이블명 select
*/
-- 식품, 음료수 ,콜라, 100개, 1000원
insert into product(pr_title,pr_contents, pr_amount,pr_price,pr_pc_num) 
	select '음료수','콜라',100,1000,pc_num from product_category where pc_name = '식품';
select*from product;