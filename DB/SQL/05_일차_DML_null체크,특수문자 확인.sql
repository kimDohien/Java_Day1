use shoppingmall_pro;

/* null 체크는 is null | is not null 을 이용해야한다 
※!= , == 으로 체크하면 안됨※ */
-- 이름을 입력한회원 조회
select * from member where me_name is not null;

-- 문자열에서 특수문자 표현
-- select * from member where me_id like '%_%';  _는 한글자 이상이면 출력됨.
select * from member where me_id like '%\_%'; -- 특수문자표현 출력은 \를 이용해야한다.