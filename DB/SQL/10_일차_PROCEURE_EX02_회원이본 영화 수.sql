use cgv;
Drop procedure if exists member_movie_count;
DELIMITER // 
create procedure member_movie_count(
in _ID varchar(20)
) 
begin 
	-- 지역 변수 선언은 위에서 모아줘야 함
	declare _movie_count int default 0; -- 지역변수선언.
    
	with ticketing_count(ss_mo_num, movie_ticketing_count)
as
(select ss_mo_num ,count(*) from ticketing 
	join screen_schedule on ti_ss_num = ss_num
	where ti_me_id LIKE _ID
	group by ss_mo_num) -- 영화별 예매 횟수, 예매한 전체 영화 수가 아님
select @NUM := count(*)from ticketing_count;
set _movie_count = (select @NUM);
update member set me_movie_count = _movie_count where me_id = _ID;
end //
DELIMITER ;

call member_movie_count('abc');