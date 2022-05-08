/*
 * 지출내역서 테이블과 지출내역구분 테이블에 데이터를 추가/수정/삭제 하는 작업을 진행 한다.
 * 		- "지출내역구분"에는 본인의 한 달치 분량의 생활비 내역을 참고하여
 * 			교통비, 식대, 수도세, 전기세 등의 구분명을 추가한다.
 * 		- "지출내역서"에는 본인의 한 달치 분량의 실제 입출고 내역을 참고하여
 * 			가계부를 작성하듯 데이터를 추가한다.
 * 		- 테이블에 추가하는 데이터는 최소 5 ~ 10개 정도는 추가하도록 한다.
 * 
 * 
 * 위 작업을 모두 마친 후에는 다음의 작업을 추가로 진행 한다.
 * 		- 입금액만을 따로 조회하여 얼마나 입금이 되었는지 통계 조회를 한다.
 * 		- 출금액만을 따로 조회하여 얼마나 출금이 되었는지 통계 조회를 한다.
 * 		- 위에서 조회한 데이터를 "월별지출내역" 테이블을 새로 만들어 월별로 저장될 수 있게 한다.
 * 		- "월별지출내역" 테이블에는 년, 월, 지출구분, 금액 컬럼을 가지게 만들고 지출구분은 '입', '출' 만 저장되도록 한다.
 */

SELECT * FROM 지출내역서;
SELECT * FROM 지출내역구분;
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = '지출내역구분';

SELECT SUM(입금액)
  FROM 지출내역서;
 
SELECT SUM(출금액)
  FROM 지출내역서;
 
CREATE TABLE 월별지출내역 (
	   년 NUMBER(4)
	 , 월 NUMBER(2)
	 , 지출구분 CHAR(3)
	 , 금액 NUMBER
);

SELECT *
  FROM 월별지출내역;
 
DROP TABLE 월별지출내역;

INSERT ALL
INTO 월별지출내역 VALUES(년, 월, 지출구분, 금액)
SELECT EXTRACT(YEAR FROM 날짜) AS 년
	 , EXTRACT(MONTH FROM 날짜) AS 월
	 , CASE WHEN 입금액 > 0 THEN '입'
	 		WHEN 출금액 > 0 THEN '출'
			END AS 지출구분
	 , CASE WHEN 입금액 > 0 THEN 입금액
	 		WHEN 출금액 > 0 THEN 출금액
			END AS 금액
FROM 지출내역서;

SELECT 년, 월, 지출구분
	 , SUM(금액)
  FROM 월별지출내역
 GROUP BY (년, 월, 지출구분)
 ORDER BY 1;

COMMIT;

/*
 * 지출내역서에 작성된 모든 지출을 기존 금액보다 10% 인상 시키고 이를 
 * 월별지출내역에도 반영하도록 한다.
 */

UPDATE 지출내역서
   SET 출금액 = 출금액 * 1.1
 WHERE 출금액 > 0;

UPDATE 월별지출내역
   SET 금액 = 금액 * 1.1
 WHERE 지출구분 = '출';

