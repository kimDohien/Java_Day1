-- abc회원이 에매한 올빼미 상영좌석을 조회(관이름, 좌석번호 조회)
select ci_name as 관이름, se_name as '좌석'from ticketing 
join ticketing_seat on ti_num = ts_ti_num
join screen_schedule on ss_num = ti_ss_num 
join movie on mo_num = ss_mo_num
join cinema on ci_num = ss_ci_num
join seat on se_num = ts_se_num
where ti_me_id = 'abc' and mo_title = '올빼미';

-- 올빼미 12월 20일 13:50상영에 예매 가능한 좌석을 조회
select se_name as '예매 가능한 좌석' , case when ts_num is null then 'O' else 'X' end as '예약가능' from(select * from screen_schedule where ss_date = '2022-12-20' and ss_time = '13:50')as ss
join (select * from movie where mo_title = '올빼미')as mo on mo_num = ss_mo_num
join cinema on ss_ci_num = ci_num
join seat on se_ci_num = ci_num
left join ticketing on ti_num = ti_ss_num
left join ticketing_seat on se_num = ts_se_num;

-- 영화별 누적 관객수를 조회
select mo_title as 영화제목 , ifnull(sum(ti_amount),0) as 누적관객수 from ticketing
join screen_schedule on ss_num = ti_ss_num 
join movie on mo_num = ss_mo_num 
where  now()>=ss_date
group by mo_num ;

select mo_title as 영화제목 , ifnull(sum(ti_amount),0) as 누적관객수 from ticketing
join (select * from screen_schedule where now()>=ss_date)as ss on ss_num = ti_ss_num 
join movie on mo_num = ss_mo_num 
group by mo_num ; 

-- 영화 순위(누적별 관객 수)를 조회
select mo_title as 영화제목 , ifnull(sum(ti_amount),0) as 누적관객수 from ticketing
join (select * from screen_schedule  where now()>=ss_date)as ss on ss_num = ti_ss_num 
join movie on mo_num = ss_mo_num 
group by mo_num 
order by 누적관객수 desc;

-- 날짜가 지났을 때 변경되어야 할 쿼리작성
UPDATE member 
SET 
    me_movie_count = (SELECT 
            COUNT(DISTINCT ss_mo_num) AS 'abc가 본 영화 갯수'
        FROM
            ticketing
                JOIN
            screen_schedule ON ss_num = ti_ss_num
        WHERE
            ss_date < NOW())
WHERE
    me_id = 'abc';
-- 회원이 본 영화 수 체크
SELECT 
            COUNT(DISTINCT ss_mo_num) AS 'abc가 본 영화 갯수'
        FROM
            ticketing
                JOIN
            screen_schedule ON ss_num = ti_ss_num
        WHERE
            ss_date < NOW();
		
-- abc회원이 예매한 올빼미 12월 20일 13:50 예매를 취소할 때 실행해야 하는 쿼리
DELETE FROM ticketing_seat 
WHERE
    ts_ti_num = 
		(SELECT ti_num FROM ticketing
			WHERE ti_ss_num = 
				(SELECT ss_num FROM screen_schedule
					WHERE ss_mo_num = 2 AND ss_date = '2022-12-20'
						AND ss_time = '13:50'
				)
                AND ti_me_id = 'abc'
		);
-- 예약 내역을 삭제 
DELETE FROM ticketing
WHERE
    ti_ss_num = 
		(SELECT ss_num FROM screen_schedule
			WHERE ss_mo_num = 2 AND ss_date = '2022-12-20'
				AND ss_time = '13:50'
		)
	AND ti_me_id = 'abc';