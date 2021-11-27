package main.vo;

public class ActionForward {
	// 요청을 처리한 후 View 페이지로 이동할 때 이동하는 방식(java의 디스패치, 리다이렉트)을 지정해 주는 클래스
	private String path;		// 이동 할 view 페이지의 url을 저장 할 변수
	private boolean redirect; 	// 이동 방식(true : 리다이렉트 , false : 디스패치)을 저장할 변수
	// boolean 변수 이므로 값을 지정하지 않으면 기본값으로 false가 들어감	
	public ActionForward() {}	
	public ActionForward(String path, boolean redirect) { 
		this.path = path;
		this.redirect = redirect;
	}
	
	public String getPath() {		
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
}
