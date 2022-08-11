package com.myhome.web.common.util;

import java.util.ArrayList;
import java.util.List;

public class Paging {

	private int offset;				// 시작 위치
	private int limit;				// 목록수 제한
	private int currentPageNumber;	// 현재 페이지
	private int nextPageNumber;		// 다음 페이지
	private int prevPageNumber;		// 이전 페이지
	private List<Integer> pageNumberList;	//페이지 리스트
	private List<Object> pageData;	//현재 페이지의 데이터
	
	public Paging(List<Object> datas, int currentPageNumber, int limit) {
		this.offset = limit * (currentPageNumber - 1);
		this.currentPageNumber = currentPageNumber;
		this.limit = limit;
		this.nextPageNumber = currentPageNumber + 1;
		this.prevPageNumber = currentPageNumber - 1;
		int pageNum = 1;
		this.pageNumberList = new ArrayList<Integer>();
		for(int i = 0; i < datas.size(); i += limit) {
			this.pageNumberList.add(pageNum++);
		}
		int max = this.offset + this.limit;
		max = max < datas.size() ? max : datas.size();
 		this.pageData = datas.subList(this.offset, max);
	}
	
	public int getOffset() {
		return offset;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	
	public int getNextPageNumber() {
		return nextPageNumber;
	}
	
	public int getPrevPageNumber() {
		return prevPageNumber;
	}
	
	public List<Integer> getPageNumberList() {
		return pageNumberList;
	}
	
	public List<Integer> getPageNumberList(int start, int end) {
		start = start > 0 ? start : 1;
		end = end < this.pageNumberList.size() ? end : this.pageNumberList.size();
		return pageNumberList.subList(start - 1, end);
		//start - 1을 하는 이유는 list의 인덱스는 0부터 시작하기때문이다.
	}
	
	public List<Object> getPageData() {
		return pageData;
	}
	
	public boolean hasNextPage() {
		return this.pageNumberList.contains(this.nextPageNumber);
	}
	
	public boolean hasPrevPage() {
		return this.pageNumberList.contains(this.prevPageNumber);
	}
}
