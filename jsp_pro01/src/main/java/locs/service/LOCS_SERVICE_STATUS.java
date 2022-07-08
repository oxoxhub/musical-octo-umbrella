package locs.service;

public enum LOCS_SERVICE_STATUS {
	
	SUCCESS(1, "성공"), FAILED(0, "실패"),
	LOC_ID_DUPLICATED(-1, "지역 ID 중복 오류"),
	CTY_ID_NOT_EXISTS(-2, "국가 ID 존재하지 않음");

	public final int value;
	public final String msg;
	
	LOCS_SERVICE_STATUS(int value, String msg) {
		this.value = value;
		this.msg = msg;
	}
}
