-- ● '가전' 제품을 조회
-- select * from product where pr_pc_num =1 ;
select * from product where pr_pc_num = (select pc_num from product_category where pc_name ='가전');

-- ● 제품 명으로 tv를 검색하여 조회
select * from product where pr_title like '%TV%';

-- ● abc회원이 구매확정한 목록을 조회
-- buy테이블 조회 + and 이용
select * from buy where buy_me_id = 'abc' and buy_status = '구매확정';