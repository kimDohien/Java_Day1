use cgv;
-- 아바타 물의길에 출현한 감독 및 배우들을 조회하는 쿼리 작성
select mp_name as '출현한 감독 및 배우' from movie 
join movie_casting on mo_num = mc_mo_num
join movie_person on mp_num = mc_mp_num
where mo_title like '아바타-물의길' ;

-- 제임스 카메론의 참여 영화 리스트를 조회하는 쿼리
select mp_name as 이름, mo_title as 참여영화 from movie_person 
join movie_casting on mp_num = mc_mp_num
join movie on mc_mo_num = mo_num 
where mp_name like '제임스 카메론';

-- 아바타 누적 관객수를 조회하는 쿼리
select  sum(ti_amount) as '아바타 누적관객수'
from ticketing join screen_schedule on ti_ss_num = ss_num
join movie on mo_num = ss_mo_num
where now() >= ss_date and mo_title like '아바타-물의길';

-- 누적 관객 수가 1명 이상인 영화를 조회하는 퀄
select mo_title as 영화제목, sum(ti_amount) as 누적관객수 
from ticketing join screen_schedule on ti_ss_num = ss_num
join movie on mo_num = ss_mo_num
where now()>=ss_date 
group by mo_num
having 누적관객수 >= 1;
-- 집계함수를 이용했을경우에는 where절에 쓸수없다.


