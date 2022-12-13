/*
Select select_expr
	[From table_references]
    [WHERE where_condition]
    [GROUP BY {col_name | expr | position}]
    [HAVING where_condition]
    [ORDER BY {col_name, | expr | position}]
    
▶group by
- 같은 속성을 가진 값으로 묶을 때 사용
- 여러 속성을 같이 사용하며, 여러 속성이 같은 행들을 묶어서 사용
- 집계함수와 같이 사용된다
*/
SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY','')); -- OFGB를 제거하겠다는거
-- 카테고리로 분류
 select * from product group by pr_pc_num ; 

-- 카테고리별 등록 된 제품 수
 select pr_pc_num as '카테고리번호', count(pr_num) as'카테고리별 등록된 제품 수' from product group by pr_pc_num ; 

-- 카테고리별 등록된 제품 수가 최소 2개 이상인 카테고리 번호들
select pr_pc_num as '카테고리번호', count(pr_num) as '카테고리별 등록된 제품 수' 
from product group by pr_pc_num having count(pr_Num)>=2;

select pr_pc_num as '카테고리번호', count(pr_num) as '카테고리별 등록된 제품 수' 
from product group by pr_pc_num having `카테고리별 등록된 제품 수`>=2;

create view product_view as select * from product; 
select * from product_view;
-- 이렇게 검색 결과를 생성할때는 as를 꼭 써야함
-- 그치만 속성명을 바꿀때는 as를 안붙여도 됨

-- 카테고리별 가장 비싼 제품명의 가격을 조회
select pr_pc_num as '카테고리번호' ,max(pr_price) as '가장비싼제품' 
from product group by pr_pc_num;

-- 사용자별 총 구매 제품 개수를 조회
select buy_me_id as '사용자', sum(buy_amount) as '총 제품 구매 개수' 
from buy group by buy_me_id;