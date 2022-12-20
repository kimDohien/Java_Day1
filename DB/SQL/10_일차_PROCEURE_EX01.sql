DROP PROCEDURE IF EXISTS TEST1;
DELIMITER //
CREATE PROCEDURE TEST1()
BEGIN
	SHOW DATABASES;
END //
DELIMITER ;

CALL TEST1();
-- -----------------------
DROP PROCEDURE IF EXISTS TEST2;
DELIMITER //
CREATE PROCEDURE TEST2(
	IN NUM INT,
    OUT OUT_NUM INT
)
BEGIN
	SELECT NUM;
    SET OUT_NUM = NUM;
END //
DELIMITER ;

SET @T_NUM = 0;
CALL TEST2(2, @T_NUM);
SELECT @T_NUM;
