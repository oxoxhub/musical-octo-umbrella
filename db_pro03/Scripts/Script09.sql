/*
 * 인덱스 : 데이터베이스의 검색 속도를 향상 시키기 위해 사용하는 객체
 *          인덱스를 위한 추가 저장 공간이 필요하다.
 *          단, 검색 속도에 대한 향상이 있을 뿐 데이터 변경 작업의 경우에는
 *          성능이 저하된다.
 */

/*
 * 인덱스 설정 안됨
 *                                     Cost         Cardinality      Bytes
 * SELECT STATEMENT                     133                   1         63
 *     TABLE ACCESS (FULL)              133                   1         63
 */
SELECT * FROM USER_MOCK_DATA_2 WHERE ID = 10000;


/*
 * 인덱스 설정 됨
 *                                     Cost         Cardinality      Bytes
 * SELECT STATEMENT                       2                   1         63
 *     TABLE ACCESS (BY INDEX ROWID)      2                   1         63
 *         INDEX (UNIQUE SCAN)            1                   1          0
 */
SELECT * FROM USER_MOCK_DATA WHERE ID = 10000;

/*
 * Cost : 실행 예상 비용으로 값이 낮을 수록 적은 비용으로 검색을 수행 할 수 있다는 것을 의미
 *        비용이 낮을 뿐이지 빠르다고는 할 수 없음
 * 
 * Cardinality : 실행 계획에서 Access 된 Row 수
 * 
 * Bytes : 실행 계획에서 Access 된 Bytes 수
 * 
 * TABLE ACCESS (FULL) : 전체 테이블을 탐색하여 결과를 도출하게 될 것을 예상함
 * INDEX (UNIQUE SCAN) : 인덱스 객체를 참조하여 탐색 후 결과를 도출하게 될 것을 예상함
 * TABLE ACCESS (BY INDEX ROWID) : 인덱스 객체로 참조한 INDEX ROWID 로 탐색하여 결과를 도출하게 될 것을 예상함
 */


SELECT * FROM USER_MOCK_DATA WHERE EMAIL = 'gstrephanrr@live.com';

-- 고유 인덱스(중복 불가)
CREATE UNIQUE INDEX IDX_USER_MOCK_DATA_EMAIL ON USER_MOCK_DATA(EMAIL);

-- 비고유 인덱스(중복 가능)
CREATE INDEX IDX_USER_MOCK_DATA_FIRST_NAME ON USER_MOCK_DATA(FIRST_NAME);

-- 결합 인덱스
CREATE INDEX IDX_USER_MOCK_DATA_ID_FIRST_NAME ON USER_MOCK_DATA(ID, FIRST_NAME);

SELECT * FROM USER_MOCK_DATA_2 WHERE ID = 10000 AND FIRST_NAME = 'Gregory';
SELECT * FROM USER_MOCK_DATA WHERE ID = 10000 AND FIRST_NAME = 'Gregory';

SELECT * FROM USER_IND_COLUMNS;
SELECT * FROM USER_INDEXES;

-- 인덱스 재구성
ALTER INDEX IDX_USER_MOCK_DATA_ID_FIRST_NAME REBUILD;

-- 인덱스 삭제
DROP INDEX IDX_USER_MOCK_DATA_EMAIL;