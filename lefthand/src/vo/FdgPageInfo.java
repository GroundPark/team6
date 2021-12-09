package vo;

public class FdgPageInfo {
	// 상품 관련 목록에서 페이징을 위해 필요한 데이터들과 검색 및 정렬에 필요한 데이터들을 저장할 클래스
		private int cpage, psize, bsize, spage, epage, rcnt, pcnt;
		// 현재 페이지 번호, 페이지 크기, 블록 크기, 시작페이지, 종료페이지, 게시물수, 페이지수
		private String sort, keyword;
		// 정렬 기준
		
		
		
		
		public int getCpage() {
			return cpage;
		}
		public String getKeyword() {
			return keyword;
		}
		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
		public void setCpage(int cpage) {
			this.cpage = cpage;
		}
		public int getPsize() {
			return psize;
		}
		public void setPsize(int psize) {
			this.psize = psize;
		}
		public int getBsize() {
			return bsize;
		}
		public void setBsize(int bsize) {
			this.bsize = bsize;
		}
		public int getSpage() {
			return spage;
		}
		public void setSpage(int spage) {
			this.spage = spage;
		}
		public int getEpage() {
			return epage;
		}
		public void setEpage(int epage) {
			this.epage = epage;
		}
		public int getRcnt() {
			return rcnt;
		}
		public void setRcnt(int rcnt) {
			this.rcnt = rcnt;
		}
		public int getPcnt() {
			return pcnt;
		}
		public void setPcnt(int pcnt) {
			this.pcnt = pcnt;
		}
		public String getSort() {
			return sort;
		}
		public void setSort(String sort) {
			this.sort = sort;
		}
	}