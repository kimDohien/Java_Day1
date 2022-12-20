use shoppingmall_pro;

-- 의류 제품들을 높은 가격순으로 조회 
select * from product join sub_category on sc_num = pr_sc_num  
join main_category on mc_num = sc_mc_num
where mc_name ='의류' order by pr_price desc ;

-- 의류 제품들을 낮은 가격순으로 조회 
select * from product join sub_category on sc_num = pr_sc_num  
join (select * from main_category where mc_name = '의류') as mc on mc.mc_num = sc_mc_num
order by pr_price asc ;
/*테이블명 대신 검색결과를 줌 .
모두다 조인한다음에 의류찾는것보다.. 의류만 선택해서 조인하면 조금더 효율적*/

set sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
-- 제품별 판매량을 조회
select pr_name as '제품이룸', ifnull(sum(ol_amount),0) as '판매개수' from order_list
right join product_option on ol_po_num = po_num
right join product on pr_num = po_pr_num
group by po_pr_num
order by '판매개수' desc;

-- 의류 제품중 제품별 판매량을 조회(제품명,판매량)
select pr_name as '제품이룸', ifnull(sum(ol_amount),0) as '판매개수' from order_list
right join product_option on ol_po_num = po_num
right join product on pr_num = po_pr_num
join sub_category on sc_num = pr_sc_num
join main_category on mc_num = sc_mc_num
where mc_name ='의류'
-- join (select * from main_category where mc_name ='의류') as mc on mc.mc_num = sc_mc_num
group by po_pr_num
order by '판매개수' desc;

-- 제품별 최신순으로 조회
select * from product order by pr_reg_date desc;

-- 제품별 최신순으로 조회, 60개씩 보기/120개씩 보기
select * from product order by pr_reg_date desc limit 60;
select * from product order by pr_reg_date desc limit 120;



