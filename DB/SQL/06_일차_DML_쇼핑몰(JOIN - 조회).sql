-- 제품명과 옵션명을 함께 조회
select * from product join product_option on po_pr_num = pr_num;

-- 제품명, 옵션명,옵션갯수 만 조회
select  pr_name, po_title, po_amount from product join product_option on po_pr_num = pr_num;

-- 제품전체 , 옵션명 조회
select  product.* , po_title from product join product_option on po_pr_num = pr_num;

-- abc 회원이 구매한 제품 옵션 번호들을 조회. 단, 중복된 제품 옵션이 있으면 제거
SELECT distinct or_me_id as 구매자, ol_po_num as '제품번호'
from `order` -- order를 기준
JOIN  order_list ON ol_or_num = or_num where or_me_id ='abc'; 

-- abc회원이 구매한 제품 명 조회
select distinct or_me_id as '구매자', pr_name as '제품명' from `order` 
join order_list on or_num = ol_or_num
join product_option on po_num = ol_po_num
join product on pr_num = po_pr_num 
where or_me_id ='abc';

-- abc 회원이 구매한 제품들이 배송된 주소지들을 조회
select or_me_id as '회원', ab_address as '주소지' from `order` 
join address_book on or_ab_num = ab_num
where or_me_id ='abc';

-- 의류로 등록된 모든 제품과 옵션들을 조회
select mc_name as '의류',pr_name as '제품명', po_title as '옵션' from product 
join sub_category on pr_sc_num = sc_num
join main_category on mc_num = sc_mc_num
join product_option on pr_num = po_pr_num
where mc_name ='의류';

-- 분류별 등록된 제품명을 조회
select distinct mc_name as '분류',sc_name as 소뷴류, ifnull( pr_name ,'등록된제품없음') as '제품명'
from product right join sub_category on pr_sc_num = sc_num -- sub_category를 기준으로 하기때문에 right조인
join main_category on mc_num = sc_mc_num


