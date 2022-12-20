use shoppingmall;
-- union
select * from product where pr_amount > 10 
				union
select * from product where pr_price>10000;

-- union all
select * from product where pr_amount > 10 
				union all
select * from product where pr_price>10000;

-- 걍 냅다 합칠수도 있음
select  pr_num as 번호 , pr_title from product
				union
select pc_num, pc_name from product_category;

