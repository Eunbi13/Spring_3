package com.iu.s3.util;

public class Pager_backUp {
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

	int perPage= 10;
	int perBlock=5;
//=====================================================	
	
	public void makeRow()throws Exception{
		

		long startRow = (getCurPage()-1)*perPage+1;
		long lastRow = getCurPage()*perPage;
		//1. 글의 전체 수

		this.setStartRow(startRow);
		this.setLastRow(lastRow);
	}

	public void makeNum(long totalCount) {

		//2. 총 페이지 수
		long totalPage=totalCount/perPage;
		if(totalCount%perPage !=0) {
			totalPage++;
		}
		//3. 총 블럭수 (페이지의 묶음)
		long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			totalBlock++;
		}
		//4. 현재 내가 있는 블럭
		long curBlock = this.getCurPage()/perBlock;
		if(this.getCurPage()%perBlock!=0) {
			curBlock++;
		}
		//5. 내가 잇는 블럭의 페이지 시작번호와 끝번호
		long startNum=(curBlock-1)*perBlock+1;
		long lastNum=curBlock*perBlock;
		//6. 내가 있는 블럭이 마지막 블럭이라면 비어있는 페이지가 출력되지 않도록 관리해야함
		if(curBlock==totalBlock) {
			lastNum=totalPage;
		}
		//7. curBlock이 첫 블록이거나 마지막 블럭일 때
		if(curBlock!=1) {
			this.setPre(true);
		}
		if(curBlock !=totalBlock) {
			this.setNext(true);
		}
		
		this.setStartNum(startNum);
		this.setLastNum(lastNum);

		System.out.println("totalPage"+totalPage);
		System.out.println("totalBlock"+totalBlock);
		System.out.println("curBlock"+curBlock);
	}

}
