package admin.act;

import javax.servlet.http.*;
import java.util.*;
import vo.*;

public class AdminPdtInAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		forward.setPath("/admin/admin_pdt_in_form.jsp");
		
		return forward;
	}
}
