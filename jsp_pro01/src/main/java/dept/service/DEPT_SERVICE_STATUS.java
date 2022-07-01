package dept.service;

public enum DEPT_SERVICE_STATUS {
	//열거형 객체
	SUCCESS(1, "성공"), FAILED(0, "실패"),
	DEPT_ID_DUPLICATED(-1, "부서 ID 중복 오류"),
	MNG_ID_NOT_EXISTS(-2, "관리자 ID 존재하지 않음"),
	LOC_ID_NOT_EXISTS(-3, "지역 ID 존재하지 않음"),
	DEPT_ID_NOT_EXISTS(-4, "삭제할 데이터 존재하지 않음");
	
	public final int value;
	public final String msg;
	
	DEPT_SERVICE_STATUS(int value, String msg) {	// 생성자
		this.value = value;
		this.msg = msg;
	}

}
