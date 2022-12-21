-- 예매를 하면 해당 영화상영시간에 예매 가능 좌석을 수정해주는 트리거 생성, 테스트
USE CGV;
DROP TRIGGER IF EXISTS UPDATE_SEAT;

DELIMITER //
CREATE TRIGGER UPDATE_SEAT AFTER INSERT
ON TICKETING
FOR EACH ROW
BEGIN 
UPDATE SCREEN_SCHEDULE
	SET SS_POSSIBLE_SEAT = SS_POSSIBLE_SEAT - NEW.TI_AMOUNT
WHERE SS_NUM = NEW.TI_SS_NUM;
END //
DELIMITER ;

INSERT INTO TICKETING(TI_AMOUNT, TI_SS_NUM, TI_ME_ID,TI_TOTAL_PRICE) 
VALUES(2,25,'abc',20000);
