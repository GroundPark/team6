package admin.ctrl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import admin.svc.*;	// act가 포함된 파일이므로
import vo.*;	// 로그인 후 회원정보를 저장하기 위함

@WebServlet("/backLogin")
public class x_BackLoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public x_BackLoginCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
