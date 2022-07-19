package emps.service;

public enum EMPS_SERVICE_STATUS {
	SUCCESS(1, "성공"), FAILED(0, "실패"),
	EMPS_ID_DUPLICATED(-1, "직원 ID 중복 오류"),
	EMAIL_DUPLICATED(-2, "직원 이메일 중복 오류"),
	JOB_ID_NOT_EXISTS(-3, "직급 ID 존재하지 않음"),
	MNG_ID_NOT_EXISTS(-4, "관리자 ID 존재하지 않음"),
	DEPT_ID_NOT_EXISTS(-5, "부서 ID 존재하지 않음");

	public final int value;
	public final String msg;
	
	EMPS_SERVICE_STATUS(int value, String msg) {
		this.value = value;
		this.msg = msg;
	}
}
