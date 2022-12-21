use cgv;
-- 영화이름, 관이름, 좌석이름,아이디,상영일, 상영시간 한번에 조회
select mo_title,ss_date,ss_time, ci_name,se_name, ti_me_id from ticketing 
join ticketing_seat on ti_num = ts_ti_num
join seat on se_num = ts_se_num
join screen_schedule on ss_num = ti_ss_num
join movie on mo_num = ss_mo_num
join cinema on ci_name = ss_ci_num
join member on me_id = ti_me_id;

-- 영화이름, 관이름, 좌석이름,아이디,상영일, 상영시간 한번에 조회하는 뷰 생성
CREATE VIEW TICKET_DETAIL
AS
select mo_title,ss_date,ss_time, ci_name,se_name, ti_me_id from ticketing 
join ticketing_seat on ti_num = ts_ti_num
join seat on se_num = ts_se_num
join screen_schedule on ss_num = ti_ss_num
join movie on mo_num = ss_mo_num
join cinema on ci_name = ss_ci_num
join member on me_id = ti_me_id;

SELECT * FROM TICKET_DETAIL;

-- ABC회원이 영화 예매를 위해 상용한 금액은?
drop view if exists TICKET_DETAIL2;
CREATE VIEW TICKET_DETAIL2
AS
select * from ticketing 
join ticketing_seat on ti_num = ts_ti_num
join seat on se_num = ts_se_num
join screen_schedule on ss_num = ti_ss_num
join movie on mo_num = ss_mo_num
join cinema on ci_name = ss_ci_num;

SELECT SUM(se_price)as 'abc회원이 영화 예매를 위해 사용한금액' FROM TICKET_DETAIL2 WHERE ti_ME_ID = 'abc';