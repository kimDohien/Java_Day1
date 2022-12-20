use shoppingmall;
select * from product;

-- 제품명에 tv가 들어가는 쿼리
select * from product where pr_title like '%TV%';
select * from product where pr_title like concate('%','TV','%');
-- 잘못된 예) 
-- 이유는 @a를 문자열로 취급하기때문에 검색이 안된다.
set @a = 'TV';
select * from product where pr_title like '%a%';
select * from product where pr_title like concate('%',@a,'%'); -- 이렇게는 가능하다.

select format(1000000,1000); -- ex)1000단위마다 , 붙여줌. 

-- 파일명이 주어졌을 때 확장자를 추출하는 예제
select right ('test.txt',3); -- 오른쪽부터 3자리 확장자 추출

-- adddate , subdate
select adddate(now(), interval 1 day); -- 오늘날 기준으로 하루 후
select adddate(now(), interval 1 week); -- 오늘날 기준으로 일주일 후
select adddate(now(), interval 1 month); -- 오늘날 기준으로 한달 후
select adddate(now(), interval 1 year); -- 오늘날 기준으로 일년 후
select subdate(now(), interval 1 year); -- 오늘날 기준으로 일년 전
select subdate(now(), interval 1 week); -- 오늘날 기준으로 일주일 후
