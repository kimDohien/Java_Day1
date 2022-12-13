use shoppingmall;
select * from board ;
create table board2
(select bo_num as num,
 bo_title as title, 
 bo_contents as contents,
 bo_reg_date as reg_date,
 bo_views as views,
 bo_me_id as writer
 from board);
 select*from board2;
 
 