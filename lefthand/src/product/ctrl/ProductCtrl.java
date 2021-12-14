package product.ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import product.act.*;
import vo.*;

@WebServlet("*.pdt")
public class ProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    public ProductCtrl() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	String requestUri = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = requestUri.substring(contextPath.length());
    	
    	ActionForward forward = null;
    	Action action = null;
    	switch (command) {
    	case "/pdt_list.pdt" :			
    		action = new PdtListAct();
			break;
		case "/pdt_view.pdt" :			
    		action = new PdtViewAct();
			break;
		}
		    	
    	try {
    		forward = action.execute(request, response);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	if(forward != null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		} else {
    			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
	}
        

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}