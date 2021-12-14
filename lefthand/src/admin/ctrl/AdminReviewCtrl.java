package admin.ctrl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import admin.svc.*;
import vo.*;

@WebServlet("/chview")
public class AdminReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminReviewCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int rlidx = Integer.parseInt(request.getParameter("rlidx"));
		String piid = request.getParameter("piid");
		String miid = request.getParameter("miid");
		String view = request.getParameter("view");
		
		try {
			AdminReviewSvc adminReviewSvc = new AdminReviewSvc();
			int vcnt = adminReviewSvc.setReview(rlidx, piid, miid, view);
			out.println(vcnt);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
