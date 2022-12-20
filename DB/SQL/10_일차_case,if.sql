use shoppingmall;

-- 가격이 20,000이상이면 비쌈, 가격이 5000원 이하이면 싸다, 아니면 적당
select pr_title, pr_price,
case 
	when pr_price >= 20000
	then '비쌈'
    when pr_price >= 20000
	then '쌈'
    else '적당'
end as '가격판별'
 from product;
 
 select pr_title, pr_price,
	if(pr_price >= 20000 ,'비쌈',
    if( pr_price >= 20000,'쌈','적당'))as '가격판별'
 from product;
 
 