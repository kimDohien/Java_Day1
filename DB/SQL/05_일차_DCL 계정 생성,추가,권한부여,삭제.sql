
-- <계정 생성,추가>
-- test계정 추가. 비번 설정 X
create user test; 

-- test1인 계정 추가 비번이 1234
create user test1 identified by '1234';


/* <계정 접근 권한>
grant 옵션 on 데이타베이스이름.* to 사용자;
'%' : 외부에서 접근 허용
'localhost' : 내부에서 접근 허용
all privilieges : 모든 권한
*/
-- test1계정에게 shoppingmall_pro DB에 있는 모든 테이블의 select권한을 부여
grant select on shoppingmall_pro.* to test1@'%';

-- test1계정에게 shoppingmall_pro DB에 있는 모든 테이블의 모든 권한을 부여
grant all privileges on shoppingmall_pro.* to test1@'%';

/*	<권한 회수>
revoke 옵션 on 데이타베이스이름.* from 사용자;
all : 모든 권한
*/
revoke all on *.* from test1;

-- <계정 삭제>
drop user test;
