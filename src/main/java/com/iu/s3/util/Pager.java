package com.iu.s3.util;

public class Pager {
	//DB에 일정한 개수 만큼 조회
	//JSP페이지에 일정한 개수만큼 페이지 번호를 출력하고자 함
	
	private long perPage;//데이터 베이스에서 조회할 개수, 페이지당 보여줄 글의 개수(row)
	private long perBlock;//JSP에 몇개씩 출력할 것인가 한 블럭당 보여줄 page숫자의 개수(기준)
	
	public Pager(){
		this.perPage=10;
		this.perBlock=5;
		this.curPage=1;
	}
	
	private long curPage;//현재 내가 있는 페이지 번호
	private long startRow;//현재 페이지에서 보여질 db에서 조회할 row의 첫번째 숫자
	private long lastRow;//현재 페이지에서 보여질 db에서 조회할 row의 마지막 숫자
	
	public void makeRow() {
		this.startRow=(this.curPage-1)*this.perPage+1;
		this.lastRow=this.curPage*this.perPage;
	}

	private long totalPage;
	private long startNum;
	private long lastNum;
	private boolean pre;
	private boolean next;
		//1. totalCount Service에서 받아옴 db에 저장된 글의 총 갯수가 필요함
	public void makeNum(long totalCount) {
		//2.전체 글의 개수를 가지고 전체 페이지의 개수를 구해야함, 참고로 이게 마지막 번호가 됨
		totalPage = totalCount/perPage;
		if(totalCount%perPage!=0) {
			totalPage++;
		}
		//3.전체 블록, 페이지가 막 천개 이러면 보기 힘드니까 블록 나눌거임 50페이지면 10블록이 되는거임
		long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		//4. 내가 지금 있는 curPage는 몇번째 블럭인지 봐야함 이거 그래야 블록시작 번호나 끝번호를 찾을 수 있음
		//아주 간단함 내가 6페이지면 2번째 블록 3이면 1번째 블록임
		long curBlock = curPage/perBlock;
		if(curPage%perBlock!=0) {
			curBlock++;
		}
		//5.curBlock으로 startNum, lastNum 구하기 curB 1 startN 1 lastN 5/ curB 2 startN 6 lastN 10
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;
		//6. 현재curBLock이 totalBlock과 같다면 마무리 처리를 해줘야함
		if(curBlock == totalBlock) {
			lastNum=totalPage;
		}
		//7. 현재 curBlock을 기준으로 넘어갈 블록이나 돌아갈 블록이 있는지 없다면 처리해줘야함
		if(curBlock > 1) {
			this.pre=true;
		}
		if(curBlock != totalBlock) {
			this.next=true;
		}
		
	}
	//======================Search==========================
	
	private String kind;//검색할 컬럼명을 담을 변수
	private String search;//검색어 search가 null이오면 안되니까 getter에서 초기화 필요 
	
	//==================setter&getter=======================
	
	
	public long getPerPage() {
		return perPage;
	}
	public void setPerPage(long perPage) {
		this.perPage = perPage;
	}
	public long getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(long perBlock) {
		this.perBlock = perBlock;
	}
	public long getCurPage() {
		return curPage;
	}
	public void setCurPage(long curPage) {
		this.curPage = curPage;
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
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
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
	//==================================================	
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
	
	
}
