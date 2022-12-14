use shoppingmall_pro;
-- abc회원이 반집업 맨투맨(1번제품) 빨강을 2개 장바구니에 담음.
insert into basket(ba_amount,ba_me_id,ba_po_num) values(2,'abc',1);
/* insert into basket(ba_amount,ba_me_id,ba_po_num) 
select 2,'abc',po_num from product_option where po_pr_num =1 and po_title '빨강'; */

/* abc 회원이 장바구니에 담긴 모든 제품을 구매, 이때 실행되어야 하는 쿼리를 작성하세요
 적립포인트는 제품 금액의 10% ,  사용 포인튼느 없음. 배송지는 집
*/
-- 주문내역에 데이터 추가
insert into `order`(or_total_price, or_price, or_use_point,or_add_point,or_state,or_me_id,or_ab_num)
values(34000,34000,0,34000*0.1,'구매','abc',1);
-- 주문리스트에 데이터 추가
insert into order_list(ol_amount, ol_price, ol_or_num, ol_po_num)
values(2,34000,1,1);
-- 제품 옵션에 재고 번경
update product_option set po_amount =po_amount - 2 where po_num =1;

