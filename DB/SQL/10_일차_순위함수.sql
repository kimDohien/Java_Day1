use shoppingmall_pro;
-- <row_number>
select 
row_number() over(order by pr_amount desc) as 보유량순위,
pr_name as 제품명,
pr_amount as 보유량
from product;

select 
row_number() over(order by pr_price desc) as 보유량순위,
pr_name as 제품명,
pr_price as 보유량
from product;

-- <dense_rank>
select 
dense_rank() over(order by pr_amount desc) as 보유량순위,
pr_name as 제품명,
pr_amount as 보유량
from product;

select 
dense_rank() over(order by pr_price desc) as 보유량순위,
pr_name as 제품명,
pr_price as 보유량
from product;

-- <ntitle>
select 
ntile(3) over(order by pr_amount desc) as 보유량순위,
pr_name as 제품명,
pr_amount as 보유량
from product;

select 
ntile(3) over(order by pr_price desc) as 보유량순위,
pr_name as 제품명,
pr_price as 보유량
from product;

select*, lead(pr_name) over(order by pr_price asc) as 다음행값 from product;
select
	row_number()over(order by pr_price desc)
	pr_name, pr_price,
	pr_price - lead(pr_price,1,0) over(order by pr_price desc) as 가격차이 from product;

select
	row_number()over(order by pr_price desc)
	pr_name, pr_price,
	pr_price - lag(pr_price,1,0) over(order by pr_price desc) as 가격차이 from product;
    
select
	row_number()over(order by pr_price desc)
	pr_name, pr_price,
	pr_price - first_value(pr_price) over(order by pr_price desc) as 가격차이 from product;
    
select
	row_number()over(order by pr_price desc)
	pr_name, pr_price,
	cume_dist() over(order by pr_price desc)*100 as 백분율 from product;

-- 카테고리별 평균 가격 조회
select pr_sc_num as 카테고리분류번호, avg(pr_price) as 평균가격 
from product
group by(pr_pc_num);

with product_avg(분류번호,평균가격)
as 
(select pr_sc_num, avg(pr_price) 
from product
group by(pr_pc_num))
select*from product_avg order by 분류번호 asc;