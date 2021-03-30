package com.iu.s3.util;

public class Pager {
	private long curPage;
	private long startRow;
	private long lastRow;
	
	
	private long startNum;
	private long lastNum;
	
	private boolean pre;//이전 block이 잇으면 true 없으면 false
	private boolean next;
	
	
	private String kind;//검색할 컬럼명을 담을 변수
	private String search;//검색어
	
	
	
	
	
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public boolean isPre() {
		return pre;
	}
	public void setPre(boolean pre) {
		this.pre = pre;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public long getStartNum() {
		return startNum;
	}
	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}
	public long getLastNum() {
		return lastNum;
	}
	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}
	
	
	public long getCurPage() {//wow,,
		if(this.curPage<1) {
			this.curPage=1;
		}
		return curPage;
	}
	public void setCurPage(long curPage) {//여기는 매개변수 curPage
		if(this.curPage<1) {
			this.curPage=1;
		} 
		this.curPage = curPage;//얘는 맴버변수 curPage 둘은 다르다.
	}
	public long getStartRow() {
		return startRow;
	}
	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}
	public long getLastRow() {
		return lastRow;
	}
	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}
}
