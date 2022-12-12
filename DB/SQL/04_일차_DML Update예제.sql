/*
-- 열명A 의 값이 값A인 행에서, 열1의 값을 값1로, 열2의 값을 값2로 ···,열n의 값을 값n으로 수정하는 쿼리문
-- 일반적으로 열명A에는 기본키명을 사용한다
-- where = 조건절
-- update문에서 where이 생략될수 있다 = > 해당테이블의 전체 행을 수정한다는 의미
-- mysql 워크벤치에서 where절을 생략하려면 옵션을 변경해야한다

update 테이블명
	set 
		열1 = 값1,
        열2 = 값2,
        ... (여러개 있다는 뜻)
        열n = 값n
	where 열명A = 값A;
*/

use shoppingmall;
-- 1번 카테고리인 공지를 공지사항으로 수정
update board_category
	set
    bc_name = '공지사항'
    where
    bc_num =1;

select * from board_category; -- 1번이 공지사항이 맞는지 확인 + 수정되었는지 확인

-- 모든게시글의 조회수를 1로 수정
update board
	set 
	bo_views=1;
select*from board; -- 게시글 조회수 확인 + 수정되었는지 확인

-- 1번 게시글의 제목을 공지사항 입니다. 내용을 오늘은 12일 입니다 라고 수정하는 update문 작성
update board
	set
    bo_title = '공지사항',
    bo_contents = '오늘은 12일 입니다'
    where 
	bo_num = 1;
    select*from board;