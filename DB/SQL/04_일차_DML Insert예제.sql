-- use shoppingmall;

insert into shoppingmall. member(me_id, me_pw, me_name, me_birth,me_authority) values('abc','123','김도현','2000-05-01','MEMBER');

insert into member(me_id, me_pw, me_name, me_birth) values('qwe','123','심유택','2002-02-02');

insert into member(me_id,  me_name, me_birth,me_pw) values('asd','곽두팔','2002-02-02','123');

insert into member values('qwe','456','김만식','2002-05-08','MEMBER')
							,('ert','456','김대식','2002-03-08','ADMIN');
select*from member;

-- 게시판 등록
insert into board_category(bc_name) values('공지'),('자유 게시판'),('문의 게시판');

insert	into board(bo_title, bo_contents, bo_me_id, bo_bc_num)
	values('공지 제목1','내용1','qwe',1); 

select*from board_category;

select*from board;