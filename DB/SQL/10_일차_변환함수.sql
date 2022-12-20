set @num = 10; -- @num 에 10을 저장. set은 저장 개념
select @num := 20; -- @num 에 20을 저장한 후, 출력
select @num;
select @@sql_mode; -- 시스템 변수로 글로벌 변수

show variables; -- 지금DBMS에서 사용하고 있는 전역변수들 조회

-- 실수 1.23을 정수 1로 변환
select cast(1.23 as signed integer);
select convert(1.23 , signed integer);